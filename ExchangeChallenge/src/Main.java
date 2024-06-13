import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        Monedas moneda = null;
        Double cantidad;
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("""
                    ********************************************
                    ********** CONVERSOR DE MONEDAS ************
                    1.) Dolares a Bolivares
                    2.) Bolivares a Dolares
                    3.) Dolares a Peso Argentino
                    4.) Peso Argentino a Dolar
                    5.) Dolar a Peso Mexicano
                    6.) Peso Mexicano a Dolar
                    7.) Salir.
                    ********************************************
                    Escoger opción:""");
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("USD", "VES",cantidad);

                        System.out.println(cantidad+" Dolares son" + moneda.conversion_result()+" Bolivares");
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad  = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("VES","USD", cantidad);

                        System.out.println(cantidad+" Bolivares son" + moneda.conversion_result()+" Dolares");
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad  = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("USD","ARS", cantidad);

                        System.out.println(cantidad+" Dolares son" + moneda.conversion_result()+" Pesos Argentinos");
                        break;
                    case 4:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad  = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("ARS","USD", cantidad);

                        System.out.println(cantidad+" Pesos Argentinos son" + moneda.conversion_result()+" Dolares");
                        break;
                    case 5:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad  = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("USD","MXN", cantidad);

                        System.out.println(cantidad+" Dolares son" + moneda.conversion_result()+" Pesos Mexicanos");
                        break;
                    case 6:
                        System.out.println("Ingrese el monto a convertir:");
                        cantidad  = Double.parseDouble(scanner.nextLine());
                        moneda = consulta.buscaTasa("MXN","USD", cantidad);

                        System.out.println(cantidad+" Pesos Mexicanos son" + moneda.conversion_result()+" Dolares");
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Porfavor, ingrese un número válido");


                }
            } catch (NumberFormatException e) {
                System.out.println("Error, porfavor ingresa una opción válida: " + e.getMessage());
        }
    }}}
