package orderXpress.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenu {
    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void printGeneralMenu() {
        System.out.println();
        System.out.println("Меню");
        System.out.println("0. Выход");
    }

    public static String readString(String message) {
        try {
            System.out.println(message);
            return CONSOLE_READER.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(String message) {
        try {
            return Integer.parseInt(readString(message));
        } catch (NumberFormatException exc) {
            throw new RuntimeException(exc);
        }
    }
}
