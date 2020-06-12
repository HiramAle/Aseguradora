/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseguradora;

import java.util.Scanner;

/**
 *
 * @author Ale
 */
public abstract class Cobertura implements CostoCoberturas{
    private boolean dañosMat;
    private boolean robo;
    private boolean asistencia;
    private boolean defensa;
    private boolean sustitucion;
    private boolean rotura;

    //inician getters y setters 
    public boolean isDañosMat() {
        return dañosMat;
    }

    public void setDañosMat(boolean dañosMat) {
        this.dañosMat = dañosMat;
    }

    public boolean isRobo() {
        return robo;
    }

    public void setRobo(boolean robo) {
        this.robo = robo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public boolean isDefensa() {
        return defensa;
    }

    public void setDefensa(boolean defensa) {
        this.defensa = defensa;
    }

    public boolean isSustitucion() {
        return sustitucion;
    }

    public void setSustitucion(boolean sustitucion) {
        this.sustitucion = sustitucion;
    }

    public boolean isRotura() {
        return rotura;
    }

    public void setRotura(boolean rotura) {
        this.rotura = rotura;
    }
    
    

    
    
    //indica las coberturas a incluir 
    public void incluirCoberturas (){
        
        Scanner entrada = new Scanner(System.in);  
        String opc;
        System.out.println("-------- Coberturas ----------");
        
        System.out.println("¿Desea inclir daños materiales? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setDañosMat(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setDañosMat(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
        
        System.out.println("¿Desea inclir robos? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setRobo(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setRobo(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
        
       
        System.out.println("¿Desea inclir asistencia en el viaje? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setAsistencia(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setAsistencia(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
        
        System.out.println("¿Desea inclir defensa legal? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setDefensa(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setDefensa(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
        
        System.out.println("¿Desea inclir auto de repuesto? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setSustitucion(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setSustitucion(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
        
        System.out.println("¿Desea inclir roturas de parabrisas y lunas? si/no");
        opc = entrada.nextLine();
        if (opc.toLowerCase().equals("si")){
            this.setRotura(true);
        }else if (opc.toLowerCase().equals("no")){
            this.setRotura(false);
        }else{
            System.out.println("Opcion no reconocida, intentelo de nuevo");
            incluirCoberturas();
        }
                        
        
    }
    
    
    public double calculaCostoCoberturas(){
        double cobertura = 0.0;
        
        if (this.isDañosMat()){
            cobertura += CostoCoberturas.dañosMateriales;
        }
        if (this.isRobo()){
            cobertura += CostoCoberturas.roboTotal;
        }
        if (this.isAsistencia()){
            cobertura += CostoCoberturas.servicioAsistencia;
        }
        if (this.isDefensa()){
            cobertura += CostoCoberturas.defensaLegal;
        }
        if (this.isSustitucion()){
            cobertura += CostoCoberturas.sustitucionVehiculo;
        }
        if (this.isRotura()){
            cobertura += CostoCoberturas.rotura;
        }
        
        return cobertura;
    }
}
