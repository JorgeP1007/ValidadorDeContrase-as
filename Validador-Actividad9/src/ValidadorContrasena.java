public class ValidadorContrasena implements Runnable {
    private String contrasena;
    private String tipoValidacion;
    private boolean esValido;

    public ValidadorContrasena(String contrasena, String tipoValidacion) {
        this.contrasena = contrasena;
        this.tipoValidacion = tipoValidacion;
        this.esValido = false;
    }

    @Override
    public void run() {
        ContrasenaValidator validator = new ContrasenaValidator();

        switch (tipoValidacion) {
            case "longitud":
                esValido = validator.validarLongitud(contrasena);
                break;
            case "caracterEspecial":
                esValido = validator.validarCaracterEspecial(contrasena);
                break;
            case "mayusculas":
                esValido = validator.validarMayusculas(contrasena);
                break;
            case "minusculas":
                esValido = validator.validarMinusculas(contrasena);
                break;
            case "numeros":
                esValido = validator.validarNumeros(contrasena);
                break;
        }

        System.out.println("Validación de " + tipoValidacion + ": " + (esValido ? "Válida" : "Inválida"));
    }
}
