import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
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
        Model model = new Model();
        model.crearCoche("MLD",matricula);
        model.cambiarVelocidad(matricula,velocidadActual);
        assertEquals(velocidadEsperada,Controller.incrementarVelocidad(matricula,model));

    }

    @ParameterizedTest
    @CsvSource({
            "'123ABC', 43, 42",
            "'456DEF', 100, 99",
            "'789GHI', 290, 289",
            "'101JKL', 987, 986",
            "'202MNO', 1, 0",
            "'303PQR', 101, 100",
            "'10240C', 102, 101"
    })
    void decrementarVel(String matricula,int velocidadActual, int velocidadEsperada) {
        Model model = new Model();
        model.crearCoche("MLD",matricula);
        model.cambiarVelocidad(matricula,velocidadActual);
        assertEquals(velocidadEsperada,Controller.decrementarVelocidad(matricula,model));

    }

}