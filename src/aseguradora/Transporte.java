package aseguradora;

import java.util.Scanner;

public abstract class Transporte {

    protected String marca, modelo, motor, serie, placas, tipo_uso, color;
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

    public void corregirDatos() {
        Scanner scan = new Scanner(System.in);
        String opc = "0";
        while (opc != "S") {
            System.out.println("¿Qué dato desea corregir?");
            System.out.println("1. Marca ");
            System.out.println("2. Modelo");
            System.out.println("3. Motor");
            System.out.println("4. Serie");
            System.out.println("5. Placas");
            System.out.println("6. Tipo de uso");
            System.out.println("7. Valor de factura");
            System.out.println("8. Color");
            System.out.println("Presione S para salir");
            opc = scan.nextLine();
            switch (opc) {
                case "1":
                    System.out.println("Ingrese la nueva marca:");
                    setMarca(scan.nextLine());
                    break;
                case "2":
                    System.out.println("Ingrese el nuevo modelo:");
                    setModelo(scan.nextLine());
                    break;
                case "3":
                    System.out.println("Ingrese el nuevo motor:");
                    setMotor(scan.nextLine());
                    break;
                case "4":
                    System.out.println("Ingrese la nueva serie:");
                    setSerie(scan.nextLine());
                    break;
                case "5":
                    System.out.println("Ingrese las nuevas placas:");
                    setPlacas(scan.nextLine());
                    break;
                case "6":
                    System.out.println("Ingrese el nuevo tipo de uso:");
                    setTipo_uso(scan.nextLine());
                    break;
                case "7":
                    System.out.println("Ingrese el nuevo valor de factura:");
                    setValor_factura(scan.nextDouble());
                    break;
                case "8":
                    System.out.println("Ingrese el nuevo color:");
                    setColor(scan.nextLine());
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }

        }

    }

}
