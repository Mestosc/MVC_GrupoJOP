import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @ParameterizedTest
    @CsvSource({
            "'123ABC', 'Ford Fiesta'",
            "'456DEF', 'Audi A4'",
            "'789GHI', 'BMW 320i'",
            "'101JKL', 'Toyota Corolla'",
            "'202MNO', 'Honda Civic'",
            "'303PQR', 'Chevrolet Malibu'"
    })
    void crearCoche(String matricula, String modelo) {
        Model model = new Model();
        Coche aux = model.crearCoche(modelo, matricula);
        assertNotNull(aux, "No deberia ser null");
        assertEquals(matricula, aux.matricula);
        assertEquals(modelo, aux.modelo);
    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 'Ford Fiesta'",
            "'456DEF', 'Audi A4'",
            "'789GHI', 'BMW 320i'",
            "'101JKL', 'Toyota Corolla'",
            "'202MNO', 'Honda Civic'",
            "'303PQR', 'Chevrolet Malibu'",
            "'303PBR', 'Chevrolet Malibu'"
    })
    void getCoche(String matricula, String modelo) {
        Model model = new Model();
        model.crearCoche(modelo, matricula);
        Coche aux = model.getCoche(matricula);
        assertNotNull(aux, "No deberia ser nulo");
        assertEquals(matricula, aux.matricula);
        assertEquals(modelo, aux.modelo);
    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 43, 43",
            "'456DEF', 100, 100",
            "'789GHI', 290, 290",
            "'101JKL', 987, 987",
            "'202MNO', -412, 0",
            "'303PQR', 2004, 100",
            "'10240C', 102, 0"
    })
    void cambiarVelocidad(String matricula, int velocidadCambiar, int velocidadEsperada) {
        Model model = new Model();
        model.crearCoche("Fled", matricula);
        assertEquals(velocidadEsperada, model.cambiarVelocidad(matricula, velocidadCambiar));
    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 43",
            "'456DEF', 100",
            "'789GHI', 290",
            "'101JKL', 987",
            "'202MNO', 0",
            "'303PQR', 100",
            "'10240C', 102"
    })
    void getVelocidad(String matricula, int velocidadEsperada) {
        Model model = new Model();
        model.crearCoche("Fled", matricula);
        model.cambiarVelocidad(matricula, velocidadEsperada);
        assertEquals(velocidadEsperada, model.getVelocidad(matricula));
    }

    @ParameterizedTest
    @CsvSource({
            "123ABC,123ABC,1",
            "10240C,123ABC,-1"
    })
    void incrementarVelocidad(String matriculaCreada,String matriculaBuscar,int velocidadEsperada) {
        Model model = new Model();
        model.crearCoche("Citroen M2", matriculaCreada);
        assertEquals(velocidadEsperada, model.incrementarVel(matriculaBuscar));
        assertEquals(velocidadEsperada, model.incrementarVel(matriculaBuscar));
    }
    @ParameterizedTest
    @CsvSource({
            "123ABC,123ABC,1",
            "10240C,123ABC,-1"
    })
    void decrementarVelocidad(String matriculaCreada,String matriculaBuscar,int velocidadEsperada) {
        Model model = new Model();
        model.crearCoche("Citroen M2", matriculaCreada);
        model.cambiarVelocidad(matriculaCreada,2);
        assertEquals(velocidadEsperada, model.decrementarVel(matriculaBuscar));
        assertEquals(velocidadEsperada, model.decrementarVel(matriculaBuscar));
    }
}