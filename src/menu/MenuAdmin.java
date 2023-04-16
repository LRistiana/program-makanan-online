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
        System.out.println("[4] Edit Restaurant");
        System.out.println("[5] Log Out");
        switch (inputInt("Masukan Pilihan",1,5)){
            case 1 :
                lihatRestaurant();
                break;
            case 2 :
                tambahRestaurant();
                break;
            case 3 :
                hapusRestaurant();
                break;
            case 4:
                editRestaurant();
                break;
            case 5 :
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
        }while (inputInt("Apakah ingin menambahkan menu lain?\n[1]Ya\n[0]Tidak",0,1) == 1);
    }

    private static void editRestaurant(){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||              Edit Restaurant            ||");
        System.out.println("=============================================");

        if (getListRestaurant().size() == 0){
            inputInt("belum ada restaurant\n[0]kembali",0,0);
            main(null);
        }
        System.out.println("[1] Edit nama Restaurant");
        System.out.println("[2] Edit alamat Restaurant");
        System.out.println("[3] Edit nama Menu");
        System.out.println("[4] Edit harga Menu");
        System.out.println("[5] Tambah Menu");
        System.out.println("[6] Delete Menu");
        System.out.println("[7] Kembali");

        int selectedIdRestaurant;
        int pilihan = inputInt("Pilihan");
        if (pilihan == 7){
            main(null);
        }

        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||             Daftar Restaurant           ||");
        System.out.println("=============================================");
        showListRestaurant();
        selectedIdRestaurant = inputInt("Masukan Nomer Restaurant\n[0]Kembali",0,getListRestaurant().size()) - 1;
        if (selectedIdRestaurant == -1){
            editRestaurant();
        }

        switch (pilihan){
            case 1 :
                editNamaRestaurant(selectedIdRestaurant);
                break;
            case 2:
                editAlamatRestaurant(selectedIdRestaurant);
                break;
            case 3:
                editNamaMenu(selectedIdRestaurant);
                break;
            case 4:
                editHargaMenu(selectedIdRestaurant);
                break;
            case 5:
                addMenuRestaurant(selectedIdRestaurant);
                editRestaurant();
                break;
            case 6:
                deleteMenu(selectedIdRestaurant);
                break;
            case 7:
                main(null);

        }
    }

    private static void editNamaRestaurant(int idRestaurant){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||            Edit Nama Restaurant         ||");
        System.out.println("=============================================");


        String newName = inputString("Masukan Nama Baru\n[0]Kembali");
        if (newName.equals("0")){
            editRestaurant();
        }if (inputInt("Apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)==1){
            getListRestaurant().get(idRestaurant).setNama(newName);
            editRestaurant();
        }else {
            editNamaRestaurant(idRestaurant);
        }
    }

    private static void editAlamatRestaurant(int idRestaurant){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||          Edit Alamat Restaurant         ||");
        System.out.println("=============================================");

        String newAlamt = inputString("Masukan Alamat Baru\n[0]Kembali");
        if (newAlamt.equals("0")){
            editRestaurant();
        }if (inputInt("Apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)==1){
            getListRestaurant().get(idRestaurant).setAlamat(newAlamt);
            editRestaurant();
        }else {
            editAlamatRestaurant(idRestaurant);
            }
        }

    private static void editNamaMenu(int idRestaurant){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||              Edit nama Menu             ||");
        System.out.println("=============================================");

        int idMenuSelected = idMenuPicker(idRestaurant);
        if (idMenuSelected == -1){
            editRestaurant();
        }
        String newMenuName =  inputString("Masukan Nama Menu Baru\n[0]kembali");
        if (newMenuName.equals("0")){
            editNamaRestaurant(idRestaurant);
        } else if (inputInt("Apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)==1) {
            getListRestaurant().get(idRestaurant).setMenuName(idMenuSelected,newMenuName);
            editRestaurant();
        }else {
            editNamaMenu(idRestaurant);
        }
    }
    private static void editHargaMenu(int idRestaurant){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||              Edit Harga Menu            ||");
        System.out.println("=============================================");

        int idMenuSelected = idMenuPicker(idRestaurant);
        if (idMenuSelected == -1){
            editRestaurant();
        }
        int newHarga =  inputInt("Masukan Harga Menu Baru\n[0]kembali",0);
        if (newHarga == 0){
            editHargaMenu(idRestaurant);
        } else if (inputInt("Apakah anda yakin?\n[1]Ya\n[0]Tidak",0,1)==1) {
            getListRestaurant().get(idRestaurant).setMenuharga(idMenuSelected,newHarga);
            editRestaurant();
        }else {
            editHargaMenu(idRestaurant);
        }
    }
    private static void deleteMenu(int idRestaurant){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||                Menu Admin               ||");
        System.out.println("||                hapus Menu               ||");
        System.out.println("=============================================");

        int idMenuSelected = idMenuPicker(idRestaurant);
        if (idMenuSelected == -1){
            editRestaurant();
        } else if (inputInt("Apakah Anda Yakin Mengahpus Menu Ini?\n[1]Ya\n[0]Tidak",0,1) == 1) {
            getListRestaurant().get(idRestaurant).removeMenu(idMenuSelected);
            editRestaurant();
        }else {
            deleteMenu(idRestaurant);
        }

    }
    private static int idMenuPicker(int idRestaurant){
        System.out.println("Daftar Menu Restaurant " + getListRestaurant().get(idRestaurant).getNama());
        getListRestaurant().get(idRestaurant).showAllMenu();
        if (getListRestaurant().get(idRestaurant).getTotalMenu() == 0){
            inputInt("[0]Kembali",0,0);
            return -1;//-1 adalah kembali
        }else {
            return inputInt("Pilih No menu\n[0]kembali",0,getListRestaurant().get(idRestaurant).getTotalMenu()) -1;
        }
    }
}
