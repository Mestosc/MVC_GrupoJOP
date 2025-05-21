import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Menu de la aplicacion
     */
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1.Crear Coche\n2.Cambiar Velocidad\n3.Mostrar Velocidad\n4.Subir velocidad\n5.Bajar velocidad\n6.Mostrar coches\n7.Mostrar coche\n8.Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Coche " + crearCoche() + " creado.");
                } case 2 ->  {
                    System.out.println("Nueva velocidad: " + cambiarVelocidad());
                } case 3 -> {
                    var matricula = pedirMatricula();
                    muestraVelocidad(matricula,Controller.obtenerVelocidad(matricula));
                } case 4 -> {
                    var matricula = pedirMatricula();
                    System.out.println("La velocidad ha sido cambiada a " + Controller.incrementarVelocidad(matricula));
                } case 5 -> {
                    var matricula = pedirMatricula();
                    System.out.println("La velocidad ha sido cambiada a " + Controller.decrementarVelocidad(matricula));
                } case 6 -> {
                    mostrarCoches();
                } case 7 -> {
                    var matricula = pedirMatricula();
                    mostrarCoche(matricula);
                }
            }
        } while (opcion!=8);
    }

    /**
     * Solicita la informacíon necesaria para cambiar la velocidad
     * @return La velocidad con el cambio aplicado
     */
    private static int cambiarVelocidad() {
        Scanner sc = new Scanner(System.in);
        var matricula = pedirMatricula();
        System.out.println("Indicame la nueva velocidad del vehiculo");
        var nuevaVel = sc.nextInt();
        try {
            return Controller.cambiarVelocidad(matricula, nuevaVel);
        } catch (NullPointerException e) {
            System.err.println("No existe el coche al que intenta hacerle un cambio de velocidad " + e.getMessage());
        }
        return 0;
    }

    /**
     * Muestra un coche en especifico
     * @param matricula la matricula del coche
     * @return true si el coche se muestra y existe
     */
    private static boolean mostrarCoche(String matricula) {
        Coche c = Controller.obtenerCoche(matricula);
        try {
            System.out.println("Matricula: " +  c.matricula);
            System.out.println("Modelo: " + c.modelo);
            muestraVelocidad(c.matricula,c.velocidad);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Ha habido un error al mostrar el coche: " + e.getMessage());
        }
        return false;
    }
    /**
     * Muestra los coches en el parking
     * @return los coches del parking
     */
    private static ArrayList<Coche> mostrarCoches() {
        ArrayList<Coche> coches = Controller.obtenerParking();
        if (!coches.isEmpty()) {
            for (Coche coche : coches) {
                mostrarCoche(coche.matricula);
                System.out.println();
            }
            return coches;
        }
        System.out.println("No existen coches");
        return null;
    }

    /**
     * Pide la matricula de un vehiculo
     * @return la matricula de ese vehiculo
     */
    private static String pedirMatricula() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indiqueme la matricula del vehiculo:");
        return sc.next();
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public static boolean muestraVelocidad(String matricula, Integer v) {
            System.out.println(matricula + ": " + v + "km/hr");
            return true;
    }

    /**
     * Pide toda la informacion necesaria al usuario para proceder a la creacion de un vehiculo
     * @return la matricula del coche
     */
    public static String crearCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digame la matricula del coche:");
        var matricula = sc.next();
        sc.nextLine();
        System.out.print("Digame el modelo del coche:");
        var modelo = sc.nextLine();
        Coche c = Controller.crearCoche(modelo, matricula);
        return c.matricula;
    }
}
