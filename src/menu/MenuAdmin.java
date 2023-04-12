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
        int pilihan  = inputInt("Masukan Pilihan",1,3);
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
            default:
                System.out.println("menu tidak tersedia");
        }

    }
    private static void lihatRestaurant(){
        if (Restaurants.size() != 0){
            for (int i = 0; i < Restaurants.size(); i++) {
                System.out.printf("%d.\t",i+1);
                Restaurants.get(i).showData();
            }
        }else {
            System.out.println("Tidak ada restaurant");
        }

    }
    private static void tambahRestaurant(){

        String nama = inputString("Masukan Nama Restaurant baru");
        String alamat = inputString("Masukan alamat restaurant " + nama);

        Restaurants.add(new Restaurant(nama,alamat));
        lihatRestaurant();
        System.exit(0);
    }
    private static void hapusRestaurant(){
        System.out.println("Nama Restaurant");
        lihatRestaurant();


        int resDelete = inputInt("Masukan Nomer Restauran yang ingin dihapus",1,Restaurants.size());
        int confirm = inputInt("apakah anda yakin?\n[1]Ya\n[2]Tidak",1,2);
        if (confirm == 1){
            hapusRestaurant();
        }
        Restaurants.remove(resDelete-1);
    }

}
