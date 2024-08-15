import java.util.regex.Pattern;

public class ContrasenaValidator {

    // Validar que la contraseña tenga al menos 8 caracteres
    public boolean validarLongitud(String contrasena) {
        return contrasena.length() >= 8;
    }

    // Validar que la contraseña tenga al menos un carácter especial
    public boolean validarCaracterEspecial(String contrasena) {
        String regex = "[!@#$%^&*(),.?\":{}|<>]";
        return Pattern.compile(regex).matcher(contrasena).find();
    }

    // Validar que la contraseña tenga al menos dos letras mayúsculas
    public boolean validarMayusculas(String contrasena) {
        String regex = "[A-Z]";
        long count = contrasena.chars().filter(ch -> Pattern.matches(regex, Character.toString(ch))).count();
        return count >= 2;
    }

    // Validar que la contraseña tenga al menos tres letras minúsculas
    public boolean validarMinusculas(String contrasena) {
        String regex = "[a-z]";
        long count = contrasena.chars().filter(ch -> Pattern.matches(regex, Character.toString(ch))).count();
        return count >= 3;
    }

    // Validar que la contraseña tenga al menos un número
    public boolean validarNumeros(String contrasena) {
        String regex = "[0-9]";
        return Pattern.compile(regex).matcher(contrasena).find();
    }
}
