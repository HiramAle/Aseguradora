/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseguradora;

/**
 *
 * @author Ale
 */
public interface PrimaSeguro {
    
    public final double comision = 0.02;
    public final double[] montoBaseAuto = {3500.0, 5000.0, 6500.0};
    public final double[] montoBaseMoto = {5000.0, 7200.0, 9000.0};
    public final double[] montoBaseCamion = {10000.0, 12000.0, 14000.0};
    
    public double calcularMontoPrima();
    public double calcularDeducible(String tipoSiniestro);
    public boolean aplicarDescuento(double porcentaje);
    
     
    
}
