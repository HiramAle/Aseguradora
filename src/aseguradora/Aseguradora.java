package aseguradora;

public class Aseguradora {

    public static void main(String[] args) {

        Asegurado aseg1 = new Asegurado("Alejandra", "Orozco", "Aguilar", "Buenavista", "5514175896", 1990, 12, 14, 2020, 5, 18);
        Asegurado aseg2 = new Asegurado("Juan", "Mata", "Herrera", "calle 167", "551414786", 1999, 11, 10, 2016, 8, 12);
        Asegurado aseg3 = new Asegurado("Pedro", "Gonzalez", "Guzman", "Lindavista 310", "5578361578", 1989, 2, 22, 2019, 4, 10);
        Asegurado aseg4 = new Asegurado("Armando", "Rosales", "Torres", "La Basilica 200", "5545361752", 1997, 5, 11, 2019, 1, 22);
        Asegurado aseg5 = new Asegurado("Javier", "Flores", "Jimenez", "Las torres 32-A", "5550743722", 1999, 12, 6, 2020, 11, 26);

        Transporte t1 = new Automovil("Seat", "2010", "M124", "FJGK1284", "MGKLY89", "comercial", "rojo", 15000.00, aseg1);
        Transporte t2 = new Motocicleta("Seat", "2018", "M124", "FJGK1284", "MGKLY89", "privado", "rojo", 15000.00, aseg2);
        Transporte t3 = new Camion("KIA", "2017", "M124", "KSJF4628", "APFH52", "comercial", "verde", 15000.00, aseg3);
        Transporte t4 = new Automovil("Toyota", "2019", "M248", "LDPJ2648", "PDEN46", "privado", "blanco", 15000.00, aseg4);
        Transporte t5 = new Motocicleta("Yamaha", "2020", "M155", "OJFG1379", "PLOI12", "privado", "negro", 15000.00, aseg5);

        PolizaSeguro poliza1 = new PolizaSeguro(true, true, false, true, false, false, 12785, 15, 05, 2022, 15, 05, 2025, "efectivo", t1);
        PolizaSeguro poliza2 = new PolizaSeguro(false, true, false, false, true, false, 12785, 15, 05, 2022, 15, 05, 2025, "tarjeta", t2);
        PolizaSeguro poliza3 = new PolizaSeguro(true, true, false, false, true, false, 16495, 20, 02, 2022, 20, 02, 2025, "efectivo", t3);
        PolizaSeguro poliza4 = new PolizaSeguro(false, false, false, true, true, false, 62348, 12, 10, 2022, 12, 10, 2025, "efectivo", t4);
        PolizaSeguro poliza5 = new PolizaSeguro(false, false, false, false, true, true, 48652, 4, 06, 2022, 4, 06, 2025, "tarjeta", t5);

        double prima = poliza2.calcularMontoPrima();
        System.out.println(prima);
    }

}
