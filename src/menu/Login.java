package menu;
import static utility.Input.*;
import static utility.Console.clrscr;
public class Login {
    private static final String passwordAdmin = "admin";
    private static final String passwordCustomer = "user123";
    public static void main(String[] args){
        clrscr();
        String username, password;
        System.out.println("=============================================");
        System.out.println("||          Program Makanan Online         ||");
        System.out.println("=============================================");
        while(true){
            username = inputString("Masukan Username\n[0]Keluar");
            if (username.equals("admin")){
                while(true){
                    password = inputString("\nMasukan Password\n[0]Kembali");
                    if (password.equals(passwordAdmin)){
                        MenuAdmin.main(null);
                    }else if (password.equals("0")) {
                        break;
                    } else{
                        System.err.println("Password salah!");
                    }
                }
            } else if (username.equals("customer")) {
                while(true){
                    password = inputString("\nMasukan Password\n[0]Kembali");
                    if (password.equals(passwordCustomer)){
                        MenuCustomer.main(null);
                    }else if (password.equals("0")) {
                        break;
                    } else{
                        System.err.println("Password salah!");
                    }
                }
            } else if (username.equals("0")) {
                System.exit(0);
            } else {
                System.out.println("Username tidak ditemukan!");
            }
        }
    }
}
