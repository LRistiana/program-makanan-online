package entity;

import java.util.*;

public class Order {
    private int idRestaurant;
    private int jarakAntar;
    private ArrayList<Integer> idMenu = new ArrayList<>();
    private ArrayList<Integer> kuantitas = new ArrayList<>();

    private int totalHarga = 0;

    public Order( int idRestaurant,int jarakAntar){
        this.idRestaurant = idRestaurant;
        this.jarakAntar= jarakAntar;
    }

    public void addMenu(int idMenu, int harga, int kuantitas){
        this.idMenu.add(idMenu);
        this.kuantitas.add(kuantitas);
        totalHarga += harga*kuantitas;
    }
    public void removeMenu(int indexMenu,int harga){
        this.totalHarga -= harga*this.kuantitas.get(indexMenu);
        this.idMenu.remove(indexMenu);
        this.kuantitas.remove(indexMenu);
    }
    public ArrayList<Integer> getIdMenus(){
        return idMenu;
    }
    public ArrayList<Integer> getKuantitas(){
        return kuantitas;
    }
    public int getTotalHarga(){
        return totalHarga;
    }
    public void setTotalHarga(int totalHarga){
        this.totalHarga = totalHarga;
    }
    public int getIdRestaurant(){
        return idRestaurant;
    }
    public int getJarakAntar(){
        return jarakAntar;
    }
}
