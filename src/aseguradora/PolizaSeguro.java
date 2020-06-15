/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseguradora;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    private Transporte transport;
    
    public PolizaSeguro(boolean dañosMat, boolean robo, boolean asistencia,boolean defensa, boolean sustitucion, boolean rotura) {
        super(dañosMat,robo,asistencia,defensa,sustitucion,rotura);
        emision = Calendar.getInstance();
    }

    public PolizaSeguro(boolean dañosMat, boolean robo, boolean asistencia,boolean defensa, boolean sustitucion, boolean rotura,
            int numero,int anioV,int mesV, int diaV, int anioF,int mesF, int diaF , String tipoPago, Transporte transport) {
        
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
        
        //Comision por tipo de pago 
        if (this.getTipoPago().equals("tarjeta")){
          prima += prima * PrimaSeguro.comision;    
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
        SimpleDateFormat formato = new SimpleDateFormat("yy");
            System.out.println(formato.format(c.getTime()));
        long fechaL = c.getTimeInMillis();
        long fechaA = this.getEmision().getTimeInMillis();
        long diferencia = fechaA-fechaL;
        long licencia = ((diferencia / (24 * 60 * 60 * 1000))- 5)/365;
        if (licencia < 2) {
            System.out.println(licencia);
            return true;
            //costoBase += 1000;
        }else{
           System.out.println(licencia);
           return false; 
        } 
    }
    
}
