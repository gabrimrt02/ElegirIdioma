/* Realiza un formulario, almacena todos los datos en un objeto DatosPersonales por medio de una ArrayList
 * y al finalizar la ejecución del programa muestra todos los datos recopilados en consola.
 * Además, permite elegir el idioma en el que se van a realizar las preguntas del formulario.
 */

import java.io.FileReader;
import java.nio.charset.Charset;
import java.io.File;

import java.util.Properties;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    final static String SEPARADOR = File.separator;
    final static File ESP = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_ES.properties");
    final static File ENG = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_EN.properties");
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        // if(args.length == 0)
            prop.load(new FileReader(ESP, Charset.forName("UTF8")));
        // else if(args.length == 1)
        //     prop.load(new FileReader(args[0], Charset.forName("UTF8")));
        // else
        //     System.err.println("El número de argumentos excede el máximo permitido");
        
        Scanner sc = new Scanner(System.in);
        ArrayList<DatosPersonales> datosPersonas = new ArrayList<DatosPersonales>();

        System.out.printf("%s \n\n%s \n\n", prop.getProperty("titulo"), prop.getProperty("descripcion"));

        int opcion;
        do {

            System.out.printf("%s \n1. %s \n2. %s \n3. Salir/Exit \n",
                prop.getProperty("elec_idioma"), prop.getProperty("es"), prop.getProperty("en"));

            System.out.print("Elegir... ");
            opcion = sc.nextInt();

        } while(opcion != 1 && opcion != 2 && opcion != 3); 

        sc.nextLine(); // Limpiar el buffer

        if(opcion == 2)
            prop.load(new FileReader(ENG, Charset.forName("UTF8")));
        
        if(opcion != 3) {

            int aniadirPersona;
            do {
                String nombre;
                System.out.printf("\n%s \n", prop.getProperty("nombre"));
                nombre = sc.nextLine();
                
                String profesion;
                System.out.printf("\n%s \n", prop.getProperty("profesion"));
                profesion = sc.nextLine();

                String telefono;
                System.out.printf("\n%s \n", prop.getProperty("telefono"));
                telefono = sc.nextLine();

                System.out.printf("\n%s \n", prop.getProperty("direccion"));
                String direccion = sc.nextLine();

                String email = "";
                System.out.printf("\n%s \n1. Si \n2. No \n", prop.getProperty("p_correo"));
                int opCorreo = sc.nextInt();
                sc.nextLine();
                if(opCorreo == 1) {
                    System.out.printf("\n%s \n", prop.getProperty("mail"));
                    email = sc.nextLine();
                }

                datosPersonas.add(new DatosPersonales(nombre, profesion, telefono, direccion, email));

                System.out.printf("\n%s \n1. %s\n2. %s \n",
                    prop.getProperty("p_add"), prop.getProperty("add_si"),prop.getProperty("add_no"));

                aniadirPersona = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

            } while(aniadirPersona == 1);

        } // else {
        //     datosPersonas.add(new DatosPersonales(null, null, null, null, null));
        // }

        sc.close();

        if(datosPersonas.size() >= 1) {
            for(DatosPersonales datos : datosPersonas) {
                System.out.println(datos.toString());
            }

            System.out.printf("\n%s \n", prop.getProperty("gracias"));
        } else {
            System.out.printf("\n%s", prop.getProperty("no_datos"));
        }


    }
}
