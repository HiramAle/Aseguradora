/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseguradora;

import java.util.Calendar;

/**
 *
 * @author Ale
 */
public class PolizaSeguro extends Cobertura implements PrimaSeguro  {
    
    private int numero;
    private Calendar emision;
    private Calendar inicioVigencia;
    private Calendar  finVigencia;
    private String tipoPago;

    private Transporte transport;
    
    public PolizaSeguro() {
        emision = Calendar.getInstance();
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
        this.tipoPago = tipoPago;
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
        prima += super.calculaCostoCoberturas();
        
        //Comision por tipo de pago 
        if (this.getTipoPago().equals("tarjeta")){
          prima += prima * PrimaSeguro.comision;    
        }
        //Aumento por tipo de uso 
        if (this.getTransport().tipo_uso.equals("comercial")){
           prima += 2000.0;
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
        /*
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
        }*/
        
        // verifica si hay aumento por la edad del asegurado
        
        return costoBase;
    }
    
    
}
