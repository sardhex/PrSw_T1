package cibertec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RegistroPrestamoTest {

    @Test
    @DisplayName("should return an error if the loan code is invalid.")
    void testCodigoPrestamoInvalido() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamoInvalido = "pr123";
        String codigoLibro = "A1B2C";
        String nombreUsuario = "Juan";
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now().plusDays(5);
        
        String resultado = registro.registrar(codigoPrestamoInvalido, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("Ingrese un código de préstamo válido", resultado);
    }
}
