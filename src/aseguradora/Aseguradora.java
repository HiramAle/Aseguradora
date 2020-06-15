package aseguradora;

public class Aseguradora {

    public static void main(String[] args) {
        
        Asegurado aseg1 = new Asegurado("Alejandra", "Orozco","Aguilar", "Buenavista","5514175896",2000,12,14,2020,5,18);
        Asegurado aseg2 = new Asegurado("Juan", "Mata","Herrera", "calle 167","551414786",1997,11,10,2020,4,12);
        
        Transporte t1 = new Automovil ("Seat", "2010", "M124", "FJGK1284","MGKLY89","comercial","rojo",15000.00, aseg1);
        
        PolizaSeguro poliza1 = new PolizaSeguro(true,false,false,true,true,false,12785,15,5,2022,15,5,2025,"tarjeta",t1);
        
        double prima = poliza1.calcularMontoPrima();
        System.out.println(prima);
    }
    
}
