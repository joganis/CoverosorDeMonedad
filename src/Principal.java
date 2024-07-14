import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarDivisas consulta = new ConsultarDivisas();
        GeneradorArchivo archivo = new GeneradorArchivo();
        Boolean salir = true;

        while (salir) {
            System.out.println("""
                    ********************************************************
                    Bienvenida/o al conversor de monedas
                                    
                    De:  ejemplo(BOB)     A: ejemplo(USD)
                                        
                    1. ARS - Peso argentino            
                    2. BOB - Boliviano boliviano
                    3. BRL - Real brasileño
                    4. CLP - Peso chileno
                    5. COP - Peso colombiano
                    6. USD - Dólar estadounidense
                    7. Salir
                                        
                    ******************************************************
                    """);
            System.out.println("DE: ingrese las tres letras que representen su moneda ");
            String opcion1 = teclado.nextLine().toUpperCase();

            // Verificar si la opción es válida o si el usuario desea salir
            if (opcion1.equals("7") || opcion1.equalsIgnoreCase("SALIR")) {
                salir = false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                break;
            }

            if (!opcion1.matches("[A-Z]{3}")) {
                System.out.println("Entrada no válida. Debe contener exactamente tres letras mayúsculas.");
                continue;
            }

            System.out.println("A: ingrese las tres letras que representen su moneda ");
            String opcion2 = teclado.nextLine().toUpperCase();

            if (!opcion2.matches("[A-Z]{3}")) {
                System.out.println("Entrada no válida. Debe contener exactamente tres letras mayúsculas.");
                continue;
            }

            System.out.println("Ingrese el valor a cambiar");
            double valor;
            try {
                valor = Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número.");
                continue;
            }


            Moneda moneda = consulta.consultarMoneda(opcion1);
            archivo.guardarJson(moneda);
            ConvertirMonedas conversor = new ConvertirMonedas(valor, opcion1, opcion2, moneda);
            double resultadoConsulta = conversor.convertirMoneda();
            System.out.println(moneda.USD());
            System.out.println(resultadoConsulta);
            System.out.println("DE : " + opcion1 + "  " + "A : " + opcion2 + "\n" + "Es igual a: " + resultadoConsulta);

        }
    }
}
