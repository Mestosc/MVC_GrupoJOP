public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    /**
     * Constructor de objetos coche
     * @param modelo el modelo de coche a establecer
     * @param matricula la matricula del coche
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
