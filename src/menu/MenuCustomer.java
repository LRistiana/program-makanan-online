package menu;

import entity.Order;
import entity.Restaurant;

import static utility.Input.*;
import static data.Restaurants.*;
import java.util.ArrayList;

class MenuCustomer {
    private static ArrayList<Order>orders = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("Menu Customer");
        System.out.println("[1]Buat Pesanan");
        System.out.println("[2]Lihat Pesanan");
        System.out.println("[3]Log Out");
        switch (inputInt("Masukan Pilihan",1,3)){
            case 1:
                buatPesanan();
                break;
            case 2:
                lihatPesanan();
                break;
            case 3:
                if (inputInt("anda yakin?\n[1]Ya\n[0]Tidak",0,1) == 1){
                    Login.login();
                }else {
                    main(null);
                }
        }
    }
    private static void buatPesanan(){
        if (getListRestaurant().size() == 0){

            System.out.println("Tidak ada Restaurant!");
            main(null);
        }else {
            for (int i = 0; i < getListRestaurant().size(); i++) {
                getListRestaurant().get(i).showData();

                int idRestaurantSelected = inputInt("Pilih Restaurant\n[0]Kembali",0,getListRestaurant().size()) - 1;
                if (idRestaurantSelected == -1){
                    buatPesanan();
                }else {
                    int jarakAntar = inputInt("Masukan jarak antar lokasi anda",0);

                    orders.add(new Order(idRestaurantSelected,jarakAntar));
                    addMenuOrder(idRestaurantSelected,orders.size()-1);
                    editMenuOrder(idRestaurantSelected,orders.size()-1);


                    if (inputInt("Apakah ingin membuat Pesanan Lagi?\n[1]Ya\n[0]Tidak",0,1) == 1){
                        buatPesanan();
                    }else {
                        main(null);
                    }
                }
            }
        }
    }

    private static void editMenuOrder(int idRestaurantSelected,int idOrderSelected){
        while (true){
            showOrder(idOrderSelected);
            switch (inputInt("[1]Konfirmasi Pesanan\n[2]Tambah Menu\n[3]hapus Menu\n[4]Batalkan Pesanan",1,4)){
                case 2 :
                    addMenuOrder(idRestaurantSelected,idOrderSelected);
                    continue;
                case 3:
                    removeMenuOrder(idRestaurantSelected,idOrderSelected);
                    continue;
                case 4:
                    orders.remove(idOrderSelected);
                    break;
                case 1:
                    break;
            }
            break;
        }
    }

    private static void addMenuOrder(int idRestaurantSelected,int idOrderSelected){
        Restaurant SelectedRestaurant = getListRestaurant().get(idRestaurantSelected);
        SelectedRestaurant.showAllData();
        int idMenuSelected;
        int tempKuantitas;
        do {
            idMenuSelected = inputInt("Pilih Nomer Menu",1,SelectedRestaurant.getTotalMenu()) - 1;
            tempKuantitas = inputInt("Jumlah",0);
            orders.get(idOrderSelected).addMenu(idMenuSelected, SelectedRestaurant.getHarga(idMenuSelected),tempKuantitas);
        }while (inputInt("Apakah ingin menambah menu?\n[1]Ya\n[0]Tidak",0,1) == 1);
    }
    private static void removeMenuOrder(int idRestaurantSelected,int idOrderSelected){
        Restaurant selectedRestaurant = getListRestaurant().get(idRestaurantSelected);
        Order selectedOrder = orders.get(idOrderSelected);
        showOrder(idOrderSelected);
        int noMenuOrderSelected;//nomer menu yang akan di hapus
        int hargaMenuOrderSelected;//harga menu yang akan di hapus
        do {
            if (orders.get(idOrderSelected).getIdMenus().size() == 0){
                System.out.println("Tidak Ada Menu Yang Di Pesanan");
                break;
            }
            noMenuOrderSelected = inputInt("Pilih Nomer Menu Yang Ingin Dihapus",1,selectedOrder.getIdMenus().size()) - 1;

            // mengambil harga dengan cara mengambil id menu di object order dengan indexnya yaitu noMenuOrderSelected
            hargaMenuOrderSelected = selectedRestaurant.getHarga(selectedOrder.getIdMenus().get(noMenuOrderSelected));

            //eksekusi penghapusan
            selectedOrder.removeMenu(noMenuOrderSelected,hargaMenuOrderSelected);
        }while (inputInt("Apakah ingin menghapus menu lagi?\n[1]Ya\n[0]Tidak",0,1) == 1);
    }



    private static void showOrder(int idOrder){
        Order selectedOrder = orders.get(idOrder);
        Restaurant selectedRestaurant = getListRestaurant().get(selectedOrder.getIdRestaurant());

        int tempIdMenu;
        String tempMenu;
        int tempHarga;
        System.out.println("Order No. " + idOrder);
        System.out.println("Nama Restaurant :\t" + selectedRestaurant.getNama());
        System.out.println("Alamat Restaurant :\t" + selectedRestaurant.getAlamat());

        if (selectedOrder.getIdMenus().size() != 0){
            System.out.println("No.\tID Menu\tNama Menu\tHarga\tKuantitas");
            for (int i = 0; i < selectedOrder.getIdMenus().size(); i++) {
                tempIdMenu = selectedOrder.getIdMenus().get(i);
                tempMenu = selectedRestaurant.getMenu(tempIdMenu);
                tempHarga = selectedRestaurant.getHarga(tempIdMenu);
                System.out.printf("%d\t%d\t%s\t%d\t%d\n",i,tempIdMenu,tempMenu,tempHarga,selectedOrder.getKuantitas().get(i));
            }
            System.out.println("\t\t\t\t\tTotal : Rp."+selectedOrder.getTotalHarga());
        }else{
            System.out.println("\nTidak ada Menu yang diPesan");
        }
    }
    private static void lihatPesanan(){

        if (orders.size()== 0){
            System.out.println("Tidak ada Pesanan Terbuat");
            main(null);
        }else {
            System.out.printf("%d Pesanan Terbuat", orders.size());
            for (int i = 0; i < orders.size(); i++) {
                System.out.printf("\t%d. %s\n",i,getListRestaurant().get(orders.get(i).getIdRestaurant()).getNama());
            }
            int noOrderSelected = inputInt("Pilih nomer pesanan untuk melihat detail\n[0]Kembali",0,orders.size()) - 1;
            if (noOrderSelected == -1){
                main(null);
            }else {
                showOrder(noOrderSelected);
                if (inputInt("[1]Kembali\n[0]Menu") == 1){
                    lihatPesanan();
                }else {
                    main(null);
                }
            }
        }
    }
}
