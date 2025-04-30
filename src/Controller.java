

public class Controller {
    
    public static void main(String[] args) {
        // Crear tres coches
        Model.crearCoche("LaFerrari", "SBC 1234");
        Model.crearCoche("Alpine", "HYU 4567");
        Model.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = Model.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = Model.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = View.muestraVelocidad("SBC 1234", Model.getVelocidad("SBC 1234"));

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
    public static int incrementarVelocidad(String matricula) {
        int inc =  Model.incrementarVel(matricula);
        if (inc==-1) { // Este es el manjeo del -1
            System.out.println("No existe el vehiculo"); // Normalmente no se pone esto en el Controller lo sacaria la vista pero como de momento no la tratamos represento aqui este muestreo de errores, si se usara de otra manera se lo pasaria a la vista
            return -1;
        }
        return inc; /* En el controller al crear el metodo como en este caso es la clase principal que llama a la vista y lo demás y se ejecuta
        se define model en el metodo main así que mi metodo lo necesita para poder llamar al metodo y pasarlo en la View, una alternativa seria hacer que el model y la view aqui sean atributos de la clase Controller o alguna cosa más con estaticos o así*/
    }

    /**
     * Solicita la realizacion de un incremento de velocidad
     * @param matricula la matricula del vehiculo
     * @param miModel el modelo que se va a usar para el cambio
     * @return la nueva velocidad
     */
    public static int decrementarVelocidad(String matricula) {
        int inc =  Model.decrementarVel(matricula);
        if (inc==-1) {
            System.out.println("No existe el vehiculo"); // Normalmente no se pone esto en el Controller lo sacaria la vista pero
            return -1;
        }
        return inc;
    }
}