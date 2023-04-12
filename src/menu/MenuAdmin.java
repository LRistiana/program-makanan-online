package menu;

import entity.Restaurant;

import static utility.Input.*;
import java.util.*;

class MenuAdmin {
    private static ArrayList<Restaurant>Restaurants = new ArrayList<Restaurant>();

    public static void main(String[] args){


        System.out.println("Login Succes!");
        System.out.println("Menu Admin");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Restaurant");
        System.out.println("3. Hapus Restaurant");
        System.out.println("4. Log Out");
        int pilihan  = inputInt("Masukan Pilihan",1,4);
        switch (pilihan){
            case 1 :
                lihatRestaurant();
                break;
            case 2 :
                tambahRestaurant();
                break;
            case 3 :
                hapusRestaurant();
                break;
            case 4 :
                if (inputInt("anda yakin?\n[1]Ya\n[0]Tidak",0,1) == 1){
                    Login.login();
                }else {
                    main(null);
                }
            default:
                System.out.println("menu tidak tersedia");
        }

    }

    private static void listRestaurant(){
        if (Restaurants.size() != 0){
            for (int i = 0; i < Restaurants.size(); i++) {
                System.out.printf("%d.\t",i+1);
                Restaurants.get(i).showData();
            }
        }else {
            System.out.println("Tidak ada restaurant!");
        }
    }
    private static void lihatRestaurant(){
        listRestaurant();
        inputInt("Ketik 1 untuk kembali",1,1);
        main(null);
    }
    private static void tambahRestaurant(){
        do {
            Restaurants.add(new Restaurant(inputString("Masukan Nama Restaurant baru"),inputString("Masukan alamat restaurant ")));
        }while (inputInt("Ingin Menambah Restaurant Lagi?\n[1]Ya\n[0]Tidak",0,1) == 1);
        main(null);
    }
    private static void hapusRestaurant(){
        listRestaurant();
        if (Restaurants.size() == 0){
            inputInt("Ketik 1 untuk kembali",1,1);
            main(null);
        }else {
            int indexRestaurant = inputInt("Masukan Nomer Restauran yang ingin dihapus",1,Restaurants.size());
            switch (inputInt("apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)) {
                case 1:
                    Restaurants.remove(indexRestaurant - 1);
                    if (inputInt("Apakah ingin menghapus lagi?\n[1]Ya\n[0]Tidak") == 1) {
                        hapusRestaurant();
                    }
                    break;
                case 0:
                    hapusRestaurant();
                    break;
            }
            main(null);
        }

    }

}
