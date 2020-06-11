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
    }
    
    public abstract double calculaCostoCoverturas();
}
