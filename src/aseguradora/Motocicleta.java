package aseguradora;

public class Motocicleta extends Transporte{
    private int potencia;
    private int cilindrada;

    public Motocicleta() {
    }

    public Motocicleta(String marca, String modelo, String motor, String serie, String placas, String tipo_uso, String color, double valor_factura, Asegurado aseg) {
        super(marca, modelo, motor, serie, placas, tipo_uso, color, valor_factura, aseg);
    }
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void setValor_factura(double valor_factura) {
        super.setValor_factura(valor_factura); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValor_factura() {
        return super.getValor_factura(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(String color) {
        super.setColor(color); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColor() {
        return super.getColor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTipo_uso(String tipo_uso) {
        super.setTipo_uso(tipo_uso); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTipo_uso() {
        return super.getTipo_uso(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlacas(String placas) {
        super.setPlacas(placas); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlacas() {
        return super.getPlacas(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSerie(String serie) {
        super.setSerie(serie); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerie() {
        return super.getSerie(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMotor(String motor) {
        super.setMotor(motor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMotor() {
        return super.getMotor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca(marca); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMarca() {
        return super.getMarca(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void agregarDatos(){
    
}
    
}
