package menu;

import entity.Restaurant;
import static utility.Input.*;
import static utility.Console.*;
import static data.Restaurants.*;

class MenuAdmin {
    public static void main(String[] args){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("=============================================");
        System.out.println("[1] Lihat Restaurant");
        System.out.println("[2] Tambah Restaurant");
        System.out.println("[3] Hapus Restaurant");
        System.out.println("[4] Log Out");
        switch (inputInt("Masukan Pilihan",1,4)){
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
                    Login.main(null);
                }else {
                    main(null);
                }
            default:
                System.out.println("menu tidak tersedia");
        }

    }
    private static void showListRestaurant(){
        if (getListRestaurant().size() != 0){
            for (int i = 0; i < getListRestaurant().size(); i++) {
                System.out.printf("%d.\t",i+1);
                getListRestaurant().get(i).showAllData();
            }
        }else {
            System.out.println("Tidak ada restaurant!");
        }
    }

    private static void lihatRestaurant(){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||             Daftar Restaurant           ||");
        System.out.println("=============================================");

        showListRestaurant();
        inputInt("[1]kembali",1,1);
        main(null);
    }
    private static void tambahRestaurant(){
        do {
            clrscr();
            System.out.println("=============================================");
            System.out.println("||                Menu Admin               ||");
            System.out.println("||             Tambah Restaurant           ||");
            System.out.println("=============================================");

            getListRestaurant().add(new Restaurant(inputString("Masukan Nama Restaurant baru"),inputString("Masukan alamat restaurant ")));
            if (inputInt("Tambahkan Menu?\n[1]Ya\n[0]Tidak",0,1) == 1){
                addMenuRestaurant(getListRestaurant().size()-1);//restaurant yang baru ditambahkan pasti berada di index terakir
            }
        }while (inputInt("Ingin Menambah Restaurant Lagi?\n[1]Ya\n[0]Tidak",0,1) == 1);
        main(null);
    }
    private static void hapusRestaurant(){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||             Hapus Restaurant            ||");
        System.out.println("=============================================");

        showListRestaurant();
        if (getListRestaurant().size() == 0){
            inputInt("[1]kembali",1,1);
            main(null);
        }else {
            int indexRestaurant = inputInt("Masukan Nomer Restaurant yang ingin dihapus\n[0]Kembali",0,getListRestaurant().size());
            if (indexRestaurant == 0){
                main(null);
            }
            switch (inputInt("apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)) {
                case 1:
                    getListRestaurant().remove(indexRestaurant - 1);
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

    private static void addMenuRestaurant(int idRestaurant){
        do {
            clrscr();
            System.out.println("=============================================");
            System.out.println("||                Menu Admin               ||");
            System.out.println("||               Tambah  Menu              ||");
            System.out.println("=============================================");

            //mengambil restaurant sesuai indexnya kemudian memanggil fungsi addMenu dan memasukan nama menu serta harganya
            getListRestaurant().get(idRestaurant).addMenu(inputString("Masukan nama menu"),inputInt("Masukan harganya",0));
        }while (inputInt("Apakah ingin menambahkan menu lain?\n[1]Ya\n[0] Tidak",0,1) == 1);
    }

}
