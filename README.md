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
        Fitur ini akan menampilkan list data restaurant yang dimiliki.
        program-makanan-online saat dijalankan.
    * Tambah Restaurant
        fitur ini memungkinkan admin untuk menambahkan data restaurant.
        didalam program-makanan-online.
    * Hapus Restaurant
        fitur ini memungkinkan admin untuk menghapus data restaurant.
        didalam program-makanan-online.
        untuk menggunakan fitur ini, setidaknya terdapat 1 restaurant yang sudah ditambahkan.
    * Edit Restaurant
        fitur ini memungkinkan admin untuk mengediut data restaurant.
        yang dimiliki oleh suatu restaurant.
        untuk menggunakan fitur ini, setidaknya terdapat 1 restaurant yang sudah ditambahkan.
        berikut ini data yang bisa diubah.
        * Nama Restaurant
        * Alamat Restaurant
        * Menu Restaurant
            merubah nama dan harga suatu menu, menambah menu, dan menghapus menu.
    * Log Out
    
### Customer
fitur yang dimiliki customer hanya membuat order dari restaurant yang tersedia

    * Buat Pesanan
        Fitur memungkinkan customer untuk membuat pesanan dengan memilih menu pada suatu restaurant.
        fitur ini hanya bisa digunakan saat sudah ada restaurant di dalam program.
    * Lihat Pesanan
        Fitur ini memungkinkan customer untuk melihat pesanan yang sudah dibuatnya.
        fitur ini hanya akan bisa digunakan saat sudah ada pesanan yang telah dibuat.
    * Log Out


## Akun
>Username Admin : admin<br />
>password Admin : admin

>Username Customer : customer<br />
>password customer : user123

## memulai program-makanan-online

### Login
<img width="168" alt="image" src="https://user-images.githubusercontent.com/108977710/232537769-3cd72914-3969-415b-be9a-d2bc6e34e089.png">

pada menu ini user diminta memasukan username dan password<br />
setelah berhasil login, user akan diarahkan ke menu admin atau menu customer<br />
sesuai dengan akun yang digunakannya.<br />

### Menu Admin
<img width="162" alt="image" src="https://user-images.githubusercontent.com/108977710/232537895-864e0d16-3ec2-4901-a38b-f4823e5dbb85.png">

Menu Ini hanya akan bisa digunakan saat login menggunakan akun admin.
berikut ini merupakan fitur dari menu admin

#### Lihat Restaurant
<img width="167" alt="image" src="https://user-images.githubusercontent.com/108977710/232538358-bf3c0495-5d7f-4fcf-bab9-6bd98833725b.png">
admin dapat melihat daftar restaurant yang telah dibuat pada menu ini.

#### Tambah Restaurant
  <img width="164" alt="image" src="https://user-images.githubusercontent.com/108977710/232538046-b6cc8f20-65ee-442e-8144-3b29001d6adb.png">
  admin menambahkan restaurant pada menu ini.
  admin dapat menambahkan langsung menu pada restarant atau memilih untuk tidak memasukan menu.

#### hapus Restaurant
  <img width="168" alt="image" src="https://user-images.githubusercontent.com/108977710/232538658-a01aae43-e97b-4f42-b71f-4b566ee31590.png">
  admin dapat menghapus restaurant yang ada pada menu ini.

#### edit restaurant
<img width="168" alt="image" src="https://user-images.githubusercontent.com/108977710/232538846-45e71b5a-40ad-4dd6-bb95-ff518977cb13.png">
admin dapat mengubah data pada restaurant dengan menu ini.

### Menu Customer
<img width="162" alt="image" src="https://user-images.githubusercontent.com/108977710/232539206-8ba1f37f-af1c-4017-90ef-b5744b73d2bc.png">
Menu Ini hanya akan bisa digunakan saat login menggunakan akun customer.
berikut ini merupakan fitur yang dimiliki menu customer.

#### Buat Pesanan
<img width="169" alt="image" src="https://user-images.githubusercontent.com/108977710/232539511-10e861b1-c910-41e1-9587-5d858b3c8c33.png">
customer memembuat pesanan pada menu ini, dengan memilih restaurantnya dan jarak antar terlebih dahulu.

<img width="189" alt="image" src="https://user-images.githubusercontent.com/108977710/232539748-14335ac2-01ae-4703-aba7-9772232bd3bf.png">
kemudian memilih menu yang ingin dipesan.

<img width="272" alt="image" src="https://user-images.githubusercontent.com/108977710/232545428-8d6a4726-0fa0-4e5c-8abb-45fb2ab6597d.png">
user dapat melihat pesanannya secara keseluruhan dan dapat memilih untuk konfirmasi, edit pesanan, dan membatalkan pesanan.

#### Lihat Pesanan
<img width="166" alt="image" src="https://user-images.githubusercontent.com/108977710/232540278-328fc52e-22bf-42c0-97ec-071ce1094609.png">
user dapat melihat list pesanan yang telah terbuat di menu ini.

<img width="283" alt="image" src="https://user-images.githubusercontent.com/108977710/232545543-c3f6688e-286b-4f2b-a067-552979e2bc7f.png">
user dapat melihat salah satu pesanan secara detail.


## UML program-makanan-online
![UML program makanan online](https://user-images.githubusercontent.com/108977710/232536729-ae823393-3fde-4742-b64a-77bdcb606baf.png)

