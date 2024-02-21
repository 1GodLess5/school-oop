package cz.godless.utility;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(){
        return scanner.nextLine();
    }
}
