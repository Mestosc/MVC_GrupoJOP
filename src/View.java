import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1.Crear Coche\n2.Cambiar Velocidad\n3.Mostrar Velocidad\n4.Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println(crearCoche());
                } case 2 ->  {
                    System.out.println("Nueva velocidad: " + cambiarVelocidad());
                } case 3 -> {
                    var matricula = pedirMatricula();
                    muestraVelocidad(matricula,Controller.obtenerVelocidad(matricula));
                }
            }
        } while (opcion!=4);
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
        } catch (Exception e) {
            System.err.println("No existe el coche al que intenta hacerle un cambio de velocidad " + e.getMessage());
            menu();
        }
        return 0;
    }

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
    public static boolean muestraVelocidad(String matricula, Integer v){
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
        System.out.print("Digame el modelo del coche:");
        var modelo = sc.next();
        Coche c = Controller.crearCoche(modelo, matricula);
        return c.matricula;
    }
}
