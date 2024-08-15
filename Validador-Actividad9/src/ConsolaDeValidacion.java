import java.util.Scanner;

public class ConsolaDeValidacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la contraseña para validar: ");
        String contrasena = scanner.nextLine();

        // Crear los hilos para cada validación
        Thread hiloLongitud = new Thread(new ValidadorContrasena(contrasena, "longitud"));
        Thread hiloCaracterEspecial = new Thread(new ValidadorContrasena(contrasena, "caracterEspecial"));
        Thread hiloMayusculas = new Thread(new ValidadorContrasena(contrasena, "mayusculas"));
        Thread hiloMinusculas = new Thread(new ValidadorContrasena(contrasena, "minusculas"));
        Thread hiloNumeros = new Thread(new ValidadorContrasena(contrasena, "numeros"));

        // Iniciar los hilos
        hiloLongitud.start();
        hiloCaracterEspecial.start();
        hiloMayusculas.start();
        hiloMinusculas.start();
        hiloNumeros.start();

        // Esperar a que todos los hilos terminen
        try {
            hiloLongitud.join();
            hiloCaracterEspecial.join();
            hiloMayusculas.join();
            hiloMinusculas.join();
            hiloNumeros.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Validación completa.");
    }
}
