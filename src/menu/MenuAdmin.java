package menu;

import entity.Restaurant;

import java.sql.SQLOutput;
import java.util.*;

class MenuAdmin {
    Scanner scan = new Scanner(System.in);
    private static ArrayList<Restaurant>Restaurants = new ArrayList<Restaurant>();
    public static void mainAdmin(){
        System.out.println("Login Succes!");
        System.exit(0);

        System.out.println("Menu Admin");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Restaurant");
        System.out.println("3. Hapus Restaurant");
        int pilihan = this.scan.nextInt();
        switch (pilihan){
            case 1 :
                lihatRestauran();
            case 2 :
                tambahRestaurant();
            case 3 :
                hapusRestaurant();
            default:
                System.out.println("menu tidak tersedia");
        }

    }
    private static void lihatRestauran(){
        for (int i = 0; i < Restaurants.size(); i++) {
            Restaurants.get(i).showData();
        }

    }
    private static void tambahRestaurant(){
        String nama, alamat;


        System.out.println("MASUKAN NAMA RESTAURANT");
        nama = this.scan.nextLine();
        System.out.println("MASUKAN ALAMAT RESTAURANT");
        alamat = this.scan.nextLine();
        Restaurants.add(new Restaurant(nama,alamat));

    }
    private static void hapusRestaurant(){
        System.out.println("Nama Restaurant");
        lihatRestauran();

        System.out.println("Masukan Nomer Restaurant yang ingin di hapus");
        int resDelete = this.scan.nextInt();

        System.out.println("apakah anda yakin?\n[1]Ya\n[2]Tidak");
        int confirm = this.scan.nextInt();
        if (confirm == 1){
            hapusRestaurant();
        }
        Restaurants.remove(resDelete-1);

    }

}
