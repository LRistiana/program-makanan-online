package entity;

import java.util.*;

public class Order {
    private static int totalOrder = 0;
    private int idOrder;
    private int idRestaurant;
    private int idMenu;
    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<Integer> harga = new ArrayList<>();
    private ArrayList<Integer> kuantitas = new ArrayList<>();

    private int totalHarga;

    Order(int idRestaurant,int idMenu, ArrayList<String> menu, ArrayList<Integer> harga, ArrayList<Integer> kuantitas){
        this.idRestaurant = idRestaurant;
        this.idMenu = idMenu;
        this.menu.addAll(menu);
        this.harga.addAll(harga);
        this.kuantitas.addAll(kuantitas);

        for (int x: this.harga) {
            this.totalHarga += x;
        }

        totalOrder++;
        this.idOrder = totalOrder;
    }






}
