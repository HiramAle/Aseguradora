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

    public PolizaSeguro() {
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
        this.emision.set(year, month, date);
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(int year, int month, int date) {
        this.inicioVigencia.set(year, month, date);
    }

    public Calendar getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(int year, int month, int date) {
        this.finVigencia.set(year, month, date);
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
    //  implementacion de los metodos de la interfaz Prima seguro
    @Override
    public double calcularMontoPrima() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularDeducible(String tipoSiniestro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean aplicarDescuento(double porcentaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // implementa metodo abstracto de la clase cobertura 
    @Override
    public double calculaCostoCoverturas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
