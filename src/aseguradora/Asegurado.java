package aseguradora;
import java.util.ArrayList;
import java.util.Calendar;
public class Asegurado {
    
    private String nombre,apellidoPaterno,apellidoMaterno,domicilio;
    private ArrayList<String> telefono = new ArrayList<String>();
    private Calendar fechaNacimiento = Calendar.getInstance();
    private Calendar emisionLicencia = Calendar.getInstance();
    private char RFC[] = new char [13];

    public Asegurado() {
    }

    public Asegurado(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, 
            String telefono,int anioN, int mesN, int diaN, int anioL, int mesL, int diaL) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.telefono.add(telefono);
        this.fechaNacimiento.set(anioN, mesN-1, diaN);
        this.emisionLicencia.set(anioL, mesL-1, diaL);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.add(telefono);
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int anio, int mes, int dia) {
        this.fechaNacimiento.set(anio, mes, dia);
    }

    public char[] getRFC() {
        return RFC;
    }

    public void setRFC(char[] RFC) {
        this.RFC = RFC;
    }

    public Calendar getEmisionLicencia() {
        return emisionLicencia;
    }

    public void setEmisionLicencia(int anio,int mes, int dia) {
        this.emisionLicencia.set(anio, mes, dia);
    }
    
    
}
