package aseguradora;

public abstract class Transporte {
    
    protected String marca,modelo,motor,serie,placas,tipo_uso,color;
    protected double valor_factura;

    public Transporte() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getTipo_uso() {
        return tipo_uso;
    }

    public void setTipo_uso(String tipo_uso) {
        this.tipo_uso = tipo_uso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getValor_factura() {
        return valor_factura;
    }

    public void setValor_factura(double valor_factura) {
        this.valor_factura = valor_factura;
    }
    
    
    
}
