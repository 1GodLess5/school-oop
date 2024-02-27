package cz.godless.utility;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(){
        return scanner.nextLine();
    }

    public static int readInt() {
        while (true){
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (Exception e){
                System.out.println("Invalid input, try again.");
                scanner.nextLine();
            }
        }
    }

    public static float readFloat() {
        while (true) {
            try {
                float input = scanner.nextFloat();
                scanner.nextLine();
                return input;
            } catch (Exception e){
                System.out.println("Invalid input, try again.");
                scanner.nextLine();
            }
        }
    }
}
