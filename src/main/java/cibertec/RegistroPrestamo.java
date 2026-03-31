package cibertec;

import java.time.LocalDate;

public class RegistroPrestamo {

    public String registrar(String codigoPrestamo, String codigoLibro, String nombreUsuario, LocalDate fechaPrestamo,
            LocalDate fechaDevolucion) {

        if (!esCodigoPrestamoValido(codigoPrestamo)) {
            return "Ingrese un código de préstamo válido";
        }

        return "El préstamo ha sido registrado correctamente";
    }

    private boolean esCodigoPrestamoValido(String codigo) {
        return codigo != null && codigo.matches("^[A-Z]{2}\\d{4}$");
    }
}
