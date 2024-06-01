package Menu;

import java.util.Scanner;

public class AskData {
    private static final Scanner input = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.print(prompt + ": ");
        String string = input.nextLine();
        return string;
    }

    public static String inputString(String prompt, StringValidator validator) {
        boolean isValid = false;
        do {
            System.out.print(prompt + ": ");
            String string = input.nextLine();
            isValid = validator.stringValidator(string);
            if (isValid)
                return string;
            else
                System.out.println("Try again");
        } while (!isValid);
        return null;
    }

    public static int inputInteger(String prompt) {
        System.out.print(prompt + ": ");
        int integer = input.nextInt();
        return integer;
    }

    public static int inputInteger(String prompt, IntegerValidator validator) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine(); // Consumir el salto de línea
                if (validator.integerValidator(value)) {
                    return value;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                input.next(); // Descartar la entrada inválida
            }
        }
    }

    public static boolean inputBoolean(String prompt) {
        System.out.print(prompt + ": ");
        boolean Boolean = input.nextBoolean();
        return Boolean;
    }

    public static void bufferCleaner() {
        input.nextLine();
    }
}
