# program-makanan-online
program-makanan-online merupakan program makanan online dimana program ini membantu user untuk membuat pesanan dari salah satu restaurant yang dipilihnya
 
## Spesifikasi Program
### Dibuat dengan
Bahasa pemrgraman Java
### Tidak Menggunakan Database
karena tidak menggunakan database, data akan hilang saat program ini ditutup
### 2 jenis akun
hanya memiliki 2 jenis akun customer dan admin, masing-masing jenisnya hanya ada 1 akun

## Fitur
### Admin
fitur yang dimiliki oleh admin adalah manipulasi data restaurant
    * Lihat Restaurant
        Fitur ini akan menampilkan list data restaurant yang dimiliki
        program-makanan-online saat dijalankan.
    * Tambah Restaurant
        fitur ini memungkinkan admin untuk menambahkan data restaurant
        didalam program-makanan-online.
    * Hapus Restaurant
        fitur ini memungkinkan admin untuk menghapus data restaurant
        didalam program-makanan-online.
        untuk menggunakan fitur ini, setidaknya terdapat 1 restaurant yang sudah ditambahkan
    * Edit Restaurant
        fitur ini memungkinkan admin untuk mengediut data restaurant.
        yang dimiliki oleh suatu restaurant.
        untuk menggunakan fitur ini, setidaknya terdapat 1 restaurant yang sudah ditambahkan.
        berikut ini data yang bisa diubah
        * Nama Restaurant
        * Alamat Restaurant
        * Menu Restaurant
            merubah nama dan harga suatu menu, menambah menu, dan menghapus menu
    * Log Out
    
### Customer
fitur yang dimiliki customer hanya membuat order dari restaurant yang tersedia
    * Buat Pesanan
        Fitur memungkinkan customer untuk membuat pesanan dengan memilih menu pada suatu restaurant
        fitur ini hanya bisa digunakan saat sudah ada restaurant di dalam program
    * Lihat Pesanan
        Fitur ini memungkinkan customer untuk melihat pesanan yang sudah dibuatnya
        fitur ini hanya akan bisa digunakan saat sudah ada pesanan yang telah dibuat
    * Log Out


## Akun
>Username Admin : admin
>password Admin : admin

>Username Customer : customer
>password customer : user123

## memulai program-makanan-online

### Login
pada menu ini user diminta memasukan username dan password
setelah berhasil login, user akan diarahkan ke menu admin atau menu customer
sesuai dengan akun yang digunakannya.

### Menu Admin
Menu Ini hanya akan bisa digunakan saat login menggunakan akun admin
berikut ini merupakan fitur dari menu admin
    * Lihat Restaurant

    * Tambah Restaurant

    * hapus Restaurant

    * edit restaurant

### Menu Customer
Menu Ini hanya akan bisa digunakan saat login menggunakan akun customer
berikut ini merupakan fitur yang dimiliki menu customer
    * Buat Pesanan

    * Lihat Pesanan


## UML program-makanan-online
![UML program makanan online](https://user-images.githubusercontent.com/108977710/232536729-ae823393-3fde-4742-b64a-77bdcb606baf.png)

