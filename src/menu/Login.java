package menu;
import java.util.*;


public class Login {
    private static final String passwordAdmin = "admin";
    private static final String passwordCustomer = "user123";
    public static void login(){
        Scanner input = new Scanner(System.in);
        String username, password;

        while(true){
            System.out.println("Masukan Username ('0' untuk keluar)");
            username = input.nextLine();
            if (username.equals("admin")){
                while(true){
                    System.out.println("Masukan Password ('0' kembali)");
                    password = input.nextLine();
                    if (password.equals(passwordAdmin)){
                        MenuAdmin.main(null);
                    }else if (password.equals("0")) {
                        break;
                    } else{
                        System.out.println("Password salah!");
                    }
                }
            } else if (username.equals("customer")) {
                while(true){
                    System.out.println("Masukan Password ('0' kembali)");
                    password = input.nextLine();
                    if (password.equals(passwordCustomer)){
                        MenuCustomer.mainCustomer();
                    }else if (password.equals("0")) {
                        break;
                    } else{
                        System.out.println("Password salah!");
                    }
                }
            } else if (username.equals("0")) {
                break;
            } else {
                System.out.println("Username tidak ditemukan!");
            }
        }



    }
}
