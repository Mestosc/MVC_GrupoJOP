import java.util.ArrayList;
import java.lang.module.ModuleDescriptor; // Lo voy a dejar porque como Damian
/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula la matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula la matricula del vehiculo
     * @return La velocidad
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
    // PIERO
    public static int incrementarVel(String matricula){
       int velocidad =  getCoche(matricula).velocidad+1;
       cambiarVelocidad(matricula, velocidad);
       return  velocidad;
    }

    public static int decrementarVel(String matricula){
        int velocidad =  getCoche(matricula).velocidad-1;
        cambiarVelocidad(matricula, velocidad);
        return  velocidad;
    }
}
