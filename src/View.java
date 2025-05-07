import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Crear Coche\n2.Cambiar Velocidad\n3.Mostrar Velocidad\n4.Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println(crearCoche());
                } case 2 ->  {
                    System.out.println("Nueva velocidad: " + cambiarVelocidad());
                } case 3 -> {
                    System.out.println("Indiqueme la matricula del vehiculo:");
                    var matricula = sc.next();
                    System.out.println(muestraVelocidad(matricula,Controller.obtenerVelocidad(matricula)));
                }
            }
        } while (opcion!=4);
    }

    private static int cambiarVelocidad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inidqueme la matricula del vehiculo");
        var matricula = sc.next();
        System.out.println("Indicame la nueva velocidad del vehiculo");
        var nuevaVel = sc.nextInt();
        return Controller.cambiarVelocidad(matricula,nuevaVel);
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
