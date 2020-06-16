package aseguradora;

public class Aseguradora {

    public static void main(String[] args) {
        
        Asegurado aseg1 = new Asegurado("Alejandra", "Orozco","Aguilar", "Buenavista","5514175896",1990,12,14,2020,5,18);
        Asegurado aseg2 = new Asegurado("Juan", "Mata","Herrera", "calle 167","551414786",1999,11,10,2016,8,12);
        
        Transporte t1 = new Automovil("Seat", "2010", "M124", "FJGK1284","MGKLY89","comercial","rojo",15000.00, aseg1);
        Transporte t2 = new Motocicleta("Seat", "2018", "M124", "FJGK1284","MGKLY89","privado","rojo",15000.00, aseg2);
        
        PolizaSeguro poliza1 = new PolizaSeguro(true,true,false,true,false,false,12785,15,5,2022,15,5,2025,"efectivo",t1);
        PolizaSeguro poliza2 = new PolizaSeguro(false,true,false,false,true,false,12785,15,5,2022,15,5,2025,"tarjeta",t2);
        
        double prima = poliza2.calcularMontoPrima();
        System.out.println(prima);
    }
    
}
