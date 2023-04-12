## Janji
Saya Ananda Myzza Marhelio NIM 2100702 mengerjakan soal TP2 dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Deskripsi Tugas Praktikum 2 DPBO 2023
Buatlah program Java yang terkoneksi dengan database MySQL. Berikut spesifikasi program yang harus dibuat:
* Program bebas, kecuali program Mahasiswa dan Book Author
* Terdapat proses Create, Read, Update, dan Delete data
* Terdapat proses Autentikasi (Login, Register)*
* Menggunakan minimal 2 tabel pada database
* Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar akan ditampilkan pada UI)
* Terdapat pergantian screen pada UI
* Terdapat button navigasi untuk beralih screen
* List data ditampilkan menggunakan card (JPanel). Contoh card dengan JPanel [link]([https://drive.google.com/file/d/1TEnEay74nhGcSS9PPzQcxksIlaQhTiZ2/view?usp=sharing](https://drive.google.com/file/d/1KgziAnrk9gGPJdIbbAxXwRomt6l_JnED/view?usp=share_link))
* Boleh login dan/atau register. Tidak perlu ada enkripsi password

## Desain Program
Terdapat 9 class di program ini, yaitu:
1. **Login** merupakan class yang berfungsi agar user dapat memasuki program yang dibuat. User membutuhkan autentikasi akun dengan memasukan username dan password pada text field yang disediakan, jika username dan password terdaftar dalam database, maka user bisa memasuki program yang dibuat. Setelah user melakukan login, user akan dihadapkan menuju halaman utama (Mainframe).
2. **AlbumPanel** merupakan class JPanel utama (Mainframe) yang akan menampilkan data-data album dan artis yang ditampilkan menggunakan card. Terdapat 3 tombol navigasi, yaitu tombol Album (Tombol yang akan menampilkan daftar album), tombol Artist (Tombol yang akan menampilkan daftar artist), dan tombol Logout (Tombol untuk keluar dari halaman utama dan kembali ke halaman login). Lalu terdapat 2 tombol yang menampilkan form untuk menambahkan data Album dan Artist, yaitu tombol Add Album dan Add Artist. Proses navigasi dari Album ke Artist dan sebaliknya menggunakan prosedur bernama setPanelAlbum() dan setPanelArtist(). _Note: Class ini seharusnya dinamakan Mainframe, namun karena ketidakpahaman diawal pengerjaan tugas, sehingga nama file salah dinamakan dan tidak bisa di rename._
3. **AlbumCard** merupakan class untuk menampilkan data-data album seperti id album, judul album, tahun rilis, artis yang membuat album tersebut, dan cover album tersebut. Terdapat 8 atribut private yang 5 diantaranya digunakan untuk menampung data album yang sudah disebutkan dan 3 sisanya dgunakan untuk mengkoneksikan program dengan database, path penyimpanan cover gambar, dan atribut untuk menampilkan data. Pada setiap card ini terdapat 2 tombol untuk melakukan update data dan delete data.  Update data terhubung dengan class **UpdateAlbum**, dan delete data memiliki prosedurnya sendiri pada class ini.
4. **ArtistCard** merupakan class untuk menampilkan data-data artist seperti id artist, nama artist, tahun mulai berkarir, foto artis tersebut, dan genre artist tersebut. Terdapat 8 atribut private yang 5 diantaranya digunakan untuk menampung data artist yang sudah disebutkan dan 3 sisanya dgunakan untuk mengkoneksikan program dengan database, path penyimpanan gambar profil, dan atribut untuk menampilkan data. Pada setiap card ini terdapat 2 tombol untuk melakukan update data dan delete data. Update data terhubung dengan class **UpdateArtist**, dan delete data memiliki prosedurnya sendiri pada class ini.
5. **AddAlbum** merupakan class JFrame yang berfungsi sebagai formulir untuk mengisi data album yang baru, terdapat 2 texs field untuk pengisian judul album dan tahun perilisan, 1 dropdown yang terhubung dengan table artist, dan form untuk mengisi gambar cover album yang nantinya akan diunggah menuju database yang ada. Lalu terdapat 1 tombol back untuk kembali ke halaman utama.
6. **AddArtist** merupakan class JFrame yang berfungsi sebagai formulir untuk mengisi data artist yang baru, terdapat 2 texs field untuk pengisian nama artist dan tahun aktifnya, 1 dropdown yang terhubung dengan table genre, dan form untuk mengisi gambar profil artis yang nantinya akan diunggah menuju database yang ada. Lalu terdapat 1 tombol back untuk kembali ke halaman utama.
7. **UpdateAlbum** merupakan class JFrame yang memiliki fungsi mirip dengan **AddAlbum** dan **AddArtist** dengan perbedaannya yaitu class ini berfungsi untuk mengganti data yang sudah ada melalui tombol update yang tercantum pada setiap card di data album.
8. **UpdateArtist** merupakan class JFrame yang memiliki fungsi mirip dengan **AddAlbum** dan **AddArtist** dengan perbedaannya yaitu class ini berfungsi untuk mengganti data yang sudah ada melalui tombol update yang tercantum pada setiap card di data album.
9. **dbConnection** yaitu class untuk menghubungkan semua class di atas dengan database yang dibuat, sehingga data bisa dilakukan secara dinamis saat melakukan proses Create, Read, Update, dan Delete. Prosedur dan metode yang hadir dalam class ini juga membantu proses query pada program ini.

### Desain GUI
* Halaman Login
![image](https://user-images.githubusercontent.com/100767177/231518434-4f43c8ef-9bb2-4fe9-9328-85332ea22cab.png)
* Mainframe
![image](https://user-images.githubusercontent.com/100767177/231518506-0194bf35-e232-497a-bda3-f5c50b3ed56c.png)
* Album Card
![image](https://user-images.githubusercontent.com/100767177/231518560-8f40e161-476f-4351-9633-d49fc01457c8.png)
* Artist Card
![image](https://user-images.githubusercontent.com/100767177/231518604-4237c7fb-5f86-4dd2-9691-162626e0386e.png)
* Add Album
![image](https://user-images.githubusercontent.com/100767177/231518669-fefaedc6-7b47-43b7-861c-0c19eb808973.png)
* Add Artist
![image](https://user-images.githubusercontent.com/100767177/231518730-9526a260-6020-44c2-b6e2-3e4e9ddba393.png)
* Update Album
![image](https://user-images.githubusercontent.com/100767177/231518799-fba59345-8612-4bf4-b6cb-901b9ae8929c.png)
* Update Artist
![image](https://user-images.githubusercontent.com/100767177/231518865-ddd51406-a6a8-4e74-a99e-5d239047bd83.png)

## Alur Program
1. User melakukan login dengan memasukan username dan password, jika username terhubung dengan databasemaka autentikasiakan diterima lalu user akan diarahkan menuju mainframe.
2. Di mainframe, user dapat melakukan navigasi ke daftar album dan artist serta menambahkan data album dan artist dan log out.
3. Formulir akan muncul ketika user menekan tombol Add Album, Add Artist, dan Update.
4. Ketika pengisian formulir selesai, data akan ditampilkan melalui card yang ada. _Note: saat menambahkan/mengubah data, harap tunggu sebentar agar data foto dapat memasuki folder terlebih dahulu sebelum menekan tombol ok pada popup setelah penambahan/pengubahan data_
5. User dapat logout lalu menekan tombol x untuk keluar dari program. 

## Dokumentasi
Dokumentasi ada pada folder yang sudah disediakan di repositori ini.
