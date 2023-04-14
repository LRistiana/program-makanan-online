package menu;

import entity.Order;
import entity.Restaurant;
import static utility.Input.*;
import static data.Restaurants.*;
import java.util.ArrayList;
import static utility.Console.clrscr;
class MenuCustomer {
    private static ArrayList<Order>orders = new ArrayList<>();
    public static void main(String[] args){
        clrscr();
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
                    Login.main(null);
                }else {
                    main(null);
                }
        }
    }
    private static void buatPesanan(){
        if (getListRestaurant().size() == 0){

            System.out.println("Tidak ada Restaurant!");
            inputInt("[1]Kembali",1,1);
            main(null);
        }else {
            System.out.println("Daftar Restaurant");
            for (int i = 0; i < getListRestaurant().size(); i++) {
                System.out.printf("%d.\t",i+1);
                getListRestaurant().get(i).showData();
                System.out.println(" ");
            }
            int idRestaurantSelected = inputInt("Pilih Restaurant\n[0]Kembali",0,getListRestaurant().size()) - 1;
            if (idRestaurantSelected == -1){//kembali memilih restaurant
                buatPesanan();
            }if (getListRestaurant().get(idRestaurantSelected).getTotalMenu() == 0){//mengecek apakah terdapat menu di restaurant terpilih
                System.out.println("Restaurant ini belum memiliki menu!");
                inputInt("[1]Kembali",1,1);
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
                    if (orders.get(idOrderSelected).getIdMenus().size() == 0){//mencegah terbuatnya order dengan 0 menu dipesan
                        inputInt("Untuk membuat Pesanan Setidaknya Ada 1 menu yang dipesan!\n[1]Kembali",1,1);
                        continue;
                    }
                    break;
            }
            break;
        }
    }

    private static void addMenuOrder(int idRestaurantSelected,int idOrderSelected){
        Restaurant selectedRestaurant = getListRestaurant().get(idRestaurantSelected);
        selectedRestaurant.showAllData();
        Order selectedOrder = orders.get(idOrderSelected);
        int idMenuSelected;
        int tempKuantitas;
        do {
            idMenuSelected = inputInt("Pilih Nomer Menu",1,selectedRestaurant.getTotalMenu()) - 1;
            tempKuantitas = inputInt("Jumlah",1);
            if (selectedOrder.getIdMenus().contains(idMenuSelected)){ // cek apakah menu terpilih sudah ada di orderan
                int oldKuantitas = selectedOrder.getKuantitas().get(idMenuSelected);
                int oldTotalHarga = selectedOrder.getTotalHarga();
                selectedOrder.getKuantitas().set(idMenuSelected, oldKuantitas + tempKuantitas);
                selectedOrder.setTotalHarga(oldTotalHarga + selectedRestaurant.getHarga(idRestaurantSelected)*tempKuantitas);
            }else {// menu terpilih belum ada di orderan
                selectedOrder.addMenu(idMenuSelected, selectedRestaurant.getHarga(idMenuSelected),tempKuantitas);
            }

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

        System.out.printf("Order No. %d\n", idOrder+1);
        System.out.println("Nama Restaurant :\t" + selectedRestaurant.getNama());
        System.out.println("Alamat Restaurant :\t" + selectedRestaurant.getAlamat());
        System.out.println("Jarak Antar Lokasi :\t" + selectedOrder.getJarakAntar() + " km");

        if (selectedOrder.getIdMenus().size() != 0){
            System.out.println("No.\t\tID Menu\t\tNama Menu\t\tHarga\tKuantitas");
            for (int i = 0; i < selectedOrder.getIdMenus().size(); i++) {
                tempIdMenu = selectedOrder.getIdMenus().get(i);
                tempMenu = selectedRestaurant.getMenu(tempIdMenu);
                tempHarga = selectedRestaurant.getHarga(tempIdMenu);
                System.out.printf("%d\t\t%d\t\t\t%s\t%d\t\t%d\n",i+1,tempIdMenu+1,tempMenu,tempHarga,selectedOrder.getKuantitas().get(i));
            }
            System.out.println("\t\t\t\t\t\tTotal : Rp."+selectedOrder.getTotalHarga());
        }else{
            System.out.println("\nTidak ada Menu yang di Pesan");
        }
    }
    private static void lihatPesanan(){

        if (orders.size()== 0){
            System.out.println("Tidak ada Pesanan Terbuat");
            main(null);
        }else {
            System.out.printf("%d Pesanan Terbuat\n", orders.size());
            for (int i = 0; i < orders.size(); i++) {
                System.out.printf("\t%d.\t%s\n",i+1,getListRestaurant().get(orders.get(i).getIdRestaurant()).getNama());
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
