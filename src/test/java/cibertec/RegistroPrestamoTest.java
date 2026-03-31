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

    @Test
    @DisplayName("should return an error if the book code is invalid.")
    void shouldReturnErrorIfBookCodeIsInvalid() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamo = "PR1234";
        String codigoLibro = "A1B2";
        String nombreUsuario = "Juan";
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now().plusDays(5);
        
        String resultado = registro.registrar(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("Ingrese un código de libro válido", resultado);
    }

    @Test
    @DisplayName("should return an error if the user name is invalid.")
    void shouldReturnErrorIfUserNameIsInvalid() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamo = "PR1234";
        String codigoLibro = "A1B2C";
        String nombreUsuario = "Jua";
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now().plusDays(5);
        
        String resultado = registro.registrar(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("El nombre del usuario debe tener al menos cuatro caracteres alfabéticos", resultado);
    }

    @Test
    @DisplayName("should return an error if the loan date is invalid.")
    void shouldReturnErrorIfLoanDateIsInvalid() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamo = "PR1234";
        String codigoLibro = "A1B2C";
        String nombreUsuario = "Juan";
        LocalDate fechaPrestamo = LocalDate.now().plusDays(1);
        LocalDate fechaDevolucion = LocalDate.now().plusDays(5);
        
        String resultado = registro.registrar(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("Ingrese una fecha de préstamo válida", resultado);
    }

    @Test
    @DisplayName("should return an error if the return date is invalid.")
    void shouldReturnErrorIfReturnDateIsInvalid() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamo = "PR1234";
        String codigoLibro = "A1B2C";
        String nombreUsuario = "Juan";
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now();
        
        String resultado = registro.registrar(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("La fecha de devolución debe ser posterior a la fecha de préstamo", resultado);
    }

    @Test
    @DisplayName("should return an error if the fields are empty.")
    void shouldReturnErrorIfFieldsAreEmpty() {
        RegistroPrestamo registro = new RegistroPrestamo();
        
        String codigoPrestamo = "";
        String codigoLibro = "A1B2C";
        String nombreUsuario = "Juan";
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now().plusDays(5);
        
        String resultado = registro.registrar(codigoPrestamo, codigoLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
        
        assertEquals("Debe ingresar todos los datos requeridos", resultado);
    }
}
