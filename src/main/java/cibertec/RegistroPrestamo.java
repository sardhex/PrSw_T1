package cibertec;

import java.time.LocalDate;

public class RegistroPrestamo {

    public String registrar(String codigoPrestamo, String codigoLibro, String nombreUsuario, LocalDate fechaPrestamo,
            LocalDate fechaDevolucion) {

        if (codigoPrestamo == null || codigoPrestamo.isEmpty() || codigoLibro == null || codigoLibro.isEmpty()
                || nombreUsuario == null || nombreUsuario.isEmpty() || fechaPrestamo == null
                || fechaDevolucion == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        if (!esCodigoPrestamoValido(codigoPrestamo)) {
            return "Ingrese un código de préstamo válido";
        }

        if (!esCodigoLibroValido(codigoLibro)) {
            return "Ingrese un código de libro válido";
        }

        if (!esNombreUsuarioValido(nombreUsuario)) {
            return "El nombre del usuario debe tener al menos cuatro caracteres alfabéticos";
        }

        if (!esFechaPrestamoValida(fechaPrestamo)) {
            return "Ingrese una fecha de préstamo válida";
        }

        if (!esFechaDevolucionValida(fechaDevolucion, fechaPrestamo)) {
            return "La fecha de devolución debe ser posterior a la fecha de préstamo";
        }

        return "El préstamo ha sido registrado correctamente";
    }

    private boolean esCodigoPrestamoValido(String codigo) {
        return codigo != null && codigo.matches("^[A-Z]{2}\\d{4}$");
    }

    private boolean esCodigoLibroValido(String codigo) {
        return codigo != null && codigo.matches("^[a-zA-Z0-9]{5}$");
    }

    private boolean esNombreUsuarioValido(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-Z]{4,}$");
    }

    private boolean esFechaPrestamoValida(LocalDate fecha) {
        return fecha != null && !fecha.isAfter(LocalDate.now());
    }

    private boolean esFechaDevolucionValida(LocalDate fechaDevolucion, LocalDate fechaPrestamo) {
        return fechaDevolucion != null && fechaDevolucion.isAfter(fechaPrestamo);
    }
}
