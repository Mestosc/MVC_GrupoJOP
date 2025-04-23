import java.lang.module.ModuleDescriptor;

public class Controller {
    
    public static void main(String[] args) {
        // Instanciamos la vista y el modelo
        View miView = new View();
        Model miModel = new Model();

        // Crear tres coches
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModel.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = miModel.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = miView.muestraVelocidad("SBC 1234", miModel.getVelocidad("SBC 1234"));

        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        } ;
    }

    /**
     * Solicita la realizacion de un incremento de velocidad
     * @param matricula la matricula del vehiculo
     * @param miModel el modelo sobre el que se realiza el cambio necesario por los motivos expresados abajo
     * @return la nueva velocidad
     */
    public int incrementarVelocidad(String matricula, Model miModel) {
        return miModel.incrementarVel(String matricula); /* En el controller al crear el metodo como en este caso es la clase principal que llama a la vista y lo demás y se ejecuta
        se define model en el metodo main así que mi metodo lo necesita para poder llamar al metodo y pasarlo en la View, una alternativa seria hacer que el model y la view aqui sean atributos de la clase Controller o alguna cosa más con estaticos o así*/
    }

    /**
     * Solicita la realizacion de un incremento de velocidad
     * @param matricula la matricula del vehiculo
     * @param miModel el modelo que se va a usar para el cambio
     * @return la nueva velocidad
     */
    public int decrementarVelocidad(String matricula, Model miModel) {
        return miModel.decrementarVel(matricula);
    }
}