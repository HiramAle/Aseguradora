/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseguradora;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ale
 */
public class PolizaSeguro extends Cobertura implements PrimaSeguro  {
    
    private int numero;
    private Calendar emision;
    private Calendar inicioVigencia = Calendar.getInstance();
    private Calendar  finVigencia = Calendar.getInstance();
    private String tipoPago;
    FileWriter output;

    private Transporte transport;
    
    public PolizaSeguro(boolean dañosMat, boolean robo, boolean asistencia,boolean defensa, boolean sustitucion, boolean rotura) {
        super(dañosMat,robo,asistencia,defensa,sustitucion,rotura);
        emision = Calendar.getInstance();
    }

    public PolizaSeguro(boolean dañosMat, boolean robo, boolean asistencia,boolean defensa, boolean sustitucion, boolean rotura,
            int numero,int diaV,int mesV, int anioV, int diaF,int mesF, int anioF , String tipoPago, Transporte transport) {
        
        super(dañosMat,robo,asistencia,defensa,sustitucion,rotura);
        this.numero = numero;
        this.emision = Calendar.getInstance();
        this.inicioVigencia.set(anioV, mesV-1, diaV);
        this.finVigencia.set(anioF, mesF-1 , diaF);
        this.tipoPago = tipoPago.toLowerCase();
        this.transport = transport;
        
    }

    // setters y getters 
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getEmision() {
        return emision;
    }

    public void setEmision(int year, int month, int date) {
        this.emision.set(year, month-1, date);
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(int year, int month, int date) {
        this.inicioVigencia.set(year, month-1, date);
    }

    public Calendar getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(int year, int month, int date) {
        this.finVigencia.set(year, month-1, date);
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago.toLowerCase();
    }

    public Transporte getTransport() {
        return transport;
    }

    public void setTransport(Transporte transport) {
        this.transport = transport;
    }
    
    
    
    //  implementacion de los metodos de la interfaz Prima seguro
    @Override
    public double calcularMontoPrima() {
        double prima = 0.0;
        prima += this.calularCostoBase(transport);
        // comision por edad del asegurado
        if (this.cargoEdad(transport)) {
            prima += this.calularCostoBase(transport)*0.1;
        }
        // comision por antiguedad de la licencia 
        if (this.cargoLicencia(transport)) {
            prima += 1000.0;
        }
        //Aumento por tipo de uso 
        if (this.getTransport().tipo_uso.equals("comercial")){
           prima += 2000.0;
        }
        prima += this.calculaCostoCoberturas();
        double subtotal = prima;
        double comi = prima * PrimaSeguro.comision;
        //Comision por tipo de pago 
        if (this.getTipoPago().equals("tarjeta")){
          prima += comi;    
        }
        try {
            this.imprimirPoliza(transport, subtotal, comi, prima);
        } catch (IOException ex) {
            Logger.getLogger(PolizaSeguro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prima;
    }

    @Override
    public double calcularDeducible(String tipoSiniestro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean aplicarDescuento(double porcentaje) {
        double descuento = this.calcularMontoPrima() - (this.calcularMontoPrima() * (porcentaje/100));
        return true;
    }
    
    public double calularCostoBase(Transporte trans){
        double costoBase = 0.0;
        int mod = Integer.valueOf(trans.modelo);
        
        //Toma el costo base dependiendo del tipo de transporte 
        if (trans instanceof Automovil){
            if (mod < 2010 ) {
                costoBase = PrimaSeguro.montoBaseAuto[0];
            } else if (mod >= 2010 && mod <= 2016) {
                costoBase = PrimaSeguro.montoBaseAuto[1];
            } else if (mod >= 2017){
                costoBase = PrimaSeguro.montoBaseAuto[2];
            }
        } else if (trans instanceof Motocicleta){
            if (mod < 2010 ) {
                costoBase = PrimaSeguro.montoBaseMoto[0];
            } else if (mod >= 2010 && mod <= 2016) {
                costoBase = PrimaSeguro.montoBaseMoto[1];
            } else if (mod >= 2017){
                costoBase = PrimaSeguro.montoBaseMoto[2];
            }
        } else if (trans instanceof Camion){
            if (mod < 2010 ) {
                costoBase = PrimaSeguro.montoBaseCamion[0];
            } else if (mod >= 2010 && mod <= 2016) {
                costoBase = PrimaSeguro.montoBaseCamion[1];
            } else if (mod >= 2017){
                costoBase = PrimaSeguro.montoBaseCamion[2];
            }
        }
        
        return costoBase;
    }
    
    // verifica si hay aumento por la edad del asegurado
    public boolean cargoEdad (Transporte trans ){
        long fechaN = trans.getAseg().getFechaNacimiento().getTimeInMillis();
        long fechaA = this.getEmision().getTimeInMillis();
        long diferencia = fechaA-fechaN;
        long edad = ((diferencia / (24 * 60 * 60 * 1000))- 5)/365;
        if (edad <= 25) {
            //costoBase += costoBase*2.5;
            return true;
        }
        return false;
    }
    
    // Verifica el tiempo con la licencia
    public boolean cargoLicencia(Transporte trans ){
        
        Calendar c = trans.getAseg().getEmisionLicencia();
        long fechaL = c.getTimeInMillis();
        long fechaA = this.getEmision().getTimeInMillis();
        long diferencia = fechaA-fechaL;
        long licencia = ((diferencia / (24 * 60 * 60 * 1000))- 5)/365;
        if (licencia < 2) {
            return true;
        }else{
           return false; 
        } 
    }
    
    public void imprimirPoliza(Transporte trans,double subtotal, double comi, double total) throws IOException{
        
        SimpleDateFormat formato = new SimpleDateFormat("dd'/'MM'/'yyyy");
        try {
            output = new FileWriter("Poliza.txt");
            output.write("-------------Datos del Asegurado ------------- \t ------------------Poliza------------------");
            output.write("\n \n");
            output.write("Nombre: " + trans.getAseg().getNombre() +" "+ trans.getAseg().getApellidoPaterno()+ " " 
                    + trans.getAseg().getApellidoMaterno() +"\t\t | Numero de Poliza: "+ this.getNumero()  );
            output.write("\n");
            output.write("Direccion: "+ trans.getAseg().getDomicilio()
                    +"\t\t\t\t | Fecha de Emision: "+ formato.format(this.getEmision().getTime()));
            output.write("\n");
            output.write("Fecha de Nacimiento: "+formato.format(trans.getAseg().getFechaNacimiento().getTime())
                    +"\t\t\t | Desde: "+ formato.format(this.getInicioVigencia().getTime()));
            output.write("\n");
            output.write("Emision de Licencia: "+formato.format(trans.getAseg().getEmisionLicencia().getTime())
                    +"\t\t\t | Hasta: "+ formato.format(this.getFinVigencia().getTime()));
            output.write("\n \n");
            output.write("-------------Ddatos de vehiculo ------------- \t -----------Informacion del Pago -----------");
            output.write("\n \n");
            output.write("Marca: "+ trans.getMarca() + "\t Placas: "+ trans.getPlacas()
                    +"\t\t | Tipo de Pago: "+ this.getTipoPago());
            output.write("\n");
            output.write("Modelo: "+ trans.getModelo()+ "\t Numero de serie: "+ trans.getSerie()
                    +"\t | Moneda: Pesos Mexicanos");
            output.write("\n");
            output.write("Color: "+ trans.getColor() +"\t Tipo de uso: "+ trans.getTipo_uso()
                    +"\t\t |");
            output.write("\n");
            output.write("Motor: "+ trans.getMotor()
                    +"\t\t\t\t\t |");
            output.write("\n \n");
            output.write("---------------------------------------------------------------------------------------------");
            output.write("\n \n");
            output.write("Costo Base: \t\t\t $"+ this.calularCostoBase(trans));
            output.write("\n");
            if (this.cargoEdad(trans)) {
                output.write(" \t\t\t\t $"+String.valueOf(this.calularCostoBase(transport)*0.1)+"\t\t Cargo extra por edad del conductor");
                output.write("\n");
            }
            if (this.cargoLicencia(trans)) {
                output.write(" \t\t\t\t $1000.0 \t Cargo extra por Antigüedad de la Licencia");
                output.write("\n");
            }
            if (trans.getTipo_uso().equals("comercial")) {
                output.write(" \t\t\t\t $2000.0 \t Cargo extra por tipo de uso");
                output.write("\n");
            }
            output.write("Coberturas:");
            output.write("\n");
            output.write("Daños Materiales: ");
            if (this.isDañosMat()) {
                output.write("\t \t $1500.0 \t Propios e Incendio");
            }else{
                output.write("\t \t No Aplica \t Propios e Incendio");
            }
            output.write("\n");
            output.write("Robo Total: ");
            if (this.isRobo()) {
                output.write("\t \t \t $2000.0");
            }else{
                output.write("\t \t \t No Aplica");
            }
            output.write("\n");
            output.write("Asistencia en el viaje: ");
            if (this.isAsistencia()) {
                output.write("\t $700.0");
            }else{
                output.write("\t No Aplica");
            }
            output.write("\n");
            output.write("Defensa Legal: ");
            if (this.isDefensa()) {
                output.write("\t \t \t $700.0");
            }else{
                output.write("\t \t  \t No Aplica");
            }
            output.write("\n");
            output.write("Auto de Repuesto: ");
            if (this.isSustitucion()) {
                output.write("\t \t $500.0");
            }else{
                output.write("\t  \t No Aplica");
            }
            output.write("\n");
            output.write("Roturas: ");
            if (this.isRotura()) {
                output.write("\t\t\t $1200.0 \t Parabrisas y lunas");
            }else{
                output.write("\t\t\t No Aplica \t Parabrisas y lunas");
            }
            output.write("\n");
            
            if(this.getTipoPago().equals("tarjeta")){
                output.write("Subtotal: \t\t\t $"+ subtotal);
                output.write("\n");
                output.write("\t\t\t\t $"+ comi +"\t\t Cargo extra por pago con tarjeta");
                output.write("\n");
            }
            output.write("\n");
            output.write("TOTAL: \t\t\t\t $"+total);
        } catch (IOException ex) {
            Logger.getLogger(PolizaSeguro.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            output.close();
        }
        
    }
    
}
