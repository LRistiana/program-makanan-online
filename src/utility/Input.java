package utility;
import java.util.*;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static int inputInt(String message){
        int number;
            System.out.println(message);
            while (!sc.hasNextInt()) {
                System.out.println("Mohon masukan angka");
                sc.next();
            }
            number = sc.nextInt();
        return number;
    }


    public static int inputInt(String message,int lowerLimit){
        int number;
        while (true){
            System.out.println(message);
            while (!sc.hasNextInt()) {
                System.out.println("Mohon masukan angka");
                sc.next();
            }
            number = sc.nextInt();


            if (number >= lowerLimit) {
                break;
            }
            System.out.println("Mohon masukan Angka Tidak Bisa kurang dari" + lowerLimit);
        }
        return number;
    }


    public static int inputInt(String message,int lowerLimit, int upperLimit){
        int number;
        while (true){
            System.out.println(message);
            while (!sc.hasNextInt()) {
                System.out.println("Mohon masukan angka");
                sc.next();
            }
            number = sc.nextInt();


            if (number >= lowerLimit && number <= upperLimit) {
                break;
            }
            System.out.printf("Mohon masukan angka diantara %d dan %d",lowerLimit, upperLimit);
        }
        return number;
    }
}
