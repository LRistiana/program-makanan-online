package entity;

import java.util.*;

public class Restaurant {
    private static int totalRestaurant = 0;
    private int idRestaurant;
    private String nama;
    private String alamat;
    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<Integer> harga = new ArrayList<>();

    Restaurant(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        totalRestaurant++;
        this.idRestaurant = totalRestaurant;
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
            System.out.println("Restauran ini tidak memiliki menu");
        }else {
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("%s\t\t%d", menu[i], harga[i]);
            }
        }
    }
}
