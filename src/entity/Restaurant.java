package entity;

import java.util.*;
import static utility.Input.*;
public class Restaurant {
    private static int totalRestaurant = 0;
    private int idRestaurant;
    private String nama;
    private String alamat;
    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<Integer> harga = new ArrayList<>();

    public Restaurant(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        totalRestaurant++;
        this.idRestaurant = totalRestaurant;
        while(inputInt("Apakah ingin menambahkan menu?\n[1]Ya [0] Tidak",0,1) == 1){
//            if (inputInt("Apakah ingin menambahkan menu?\n[1]Ya [0] Tidak",0,1) == 0){
//                break;
//            }
            this.addMenu(inputString("Masukan nama menu"),inputInt("Masukan harganya",0));
        }
    }
    public int getIdRestaurant(){
        return this.idRestaurant;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void addMenu(String menu,int harga){
        this.menu.add(menu);
        this.harga.add(harga);


    }
    public void showMenu(){
        if (menu.size() == 0){
            System.out.println("\tRestauran ini tidak memiliki menu");
        }else {
            System.out.println("\tMenu :");
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("\t\t- %s\t\tRp.%d\n", menu.get(i), harga.get(i));
            }
        }
    }
    
    public void showData(){
        System.out.println(this.nama);
        System.out.println("\talamat : " + this.alamat);
        showMenu();
        System.out.println();
    }
}
