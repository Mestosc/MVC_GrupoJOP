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
        Coche aux = Model.crearCoche(modelo, matricula);
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
        Model.crearCoche(modelo, matricula);
        Coche aux = Model.getCoche(matricula);
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
            "'10240C', 102, 102"
    })
    void cambiarVelocidad(String matricula, int velocidadCambiar, int velocidadEsperada) {
        Model.crearCoche("Fled", matricula);
        assertEquals(velocidadEsperada, Model.cambiarVelocidad(matricula, velocidadCambiar));
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
        Model.crearCoche("Fled", matricula);
        Model.cambiarVelocidad(matricula, velocidadEsperada);
        assertEquals(velocidadEsperada, Model.getVelocidad(matricula));
    }

    @ParameterizedTest
    @CsvSource({
            "123ABC,1",
            "10240C,1"
    })
    void incrementarVelocidad(String matriculaCreada,int velocidadEsperada) {
        Model.crearCoche("Citroen M2", matriculaCreada);
        Model.cambiarVelocidad(matriculaCreada,0);
        assertEquals(velocidadEsperada, Model.incrementarVel(matriculaCreada));
    }
    @ParameterizedTest
    @CsvSource({
            "123ABC,1",
            "10240C,1"
    })
    void decrementarVelocidad(String matriculaCreada,int velocidadEsperada) {
        Model.crearCoche("Citroen M2", matriculaCreada);
        Model.cambiarVelocidad(matriculaCreada,2);
        assertEquals(velocidadEsperada, Model.decrementarVel(matriculaCreada));
    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 43, 44",
            "'456DEF', 100, 101",
            "'789GHI', 290, 291",
            "'101JKL', 987, 988",
            "'202MNO', 0, 1",
            "'303PQR', 100, 101",
            "'10240C', 102, 103"
    })
    void incrementarVel(String matricula,int velocidadActual, int velocidadEsperada) {
        Model.crearCoche("MLD",matricula);
        Model.cambiarVelocidad(matricula,velocidadActual);
        assertEquals(velocidadEsperada,Controller.incrementarVelocidad(matricula));

    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 43, 42",
            "'456DEF', 100, 99",
            "'789GHI', 290, 289",
            "'101JKL', 987, 986",
            "'202MNO', 0, 0",
            "'303PQR', 100, 99",
            "'10240C', 102, 101"
    })
    void decrementarVel(String matricula,int velocidadActual, int velocidadEsperada) {
        Model.crearCoche("MLD",matricula);
        Model.cambiarVelocidad(matricula,velocidadActual);
        assertEquals(velocidadEsperada,Controller.decrementarVelocidad(matricula));
    }
}