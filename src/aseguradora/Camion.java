package aseguradora;

public class Camion extends Transporte{
    
    private int capacidadCarga;
    private int capacidadRemolque;

    public Camion() {
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadRemolque() {
        return capacidadRemolque;
    }

    public void setCapacidadRemolque(int capacidadRemolque) {
        this.capacidadRemolque = capacidadRemolque;
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
    
}
