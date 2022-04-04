# Aplikasi Cek Timezone Server

Bila kita mengalami selisih antara waktu server dan waktu seharusnya, kita bisa mengecek setting timezone yang berjalan di aplikasi kita dengan aplikasi kecil ini. 

Normalnya, timezone diset di sistem operasi. Idealnya timezone di server diset ke UTC atau GMT+0. Demikian juga seluruh data transaksi di server disimpan di timezone UTC. Aplikasi kita yang ingin menampilkan jam transaksi bisa melakukan konversi ke local timezone sesuai lokasi masing-masing user.

## Cara Menjalankan Aplikasi ##

* Menggunakan timezone sesuai yang diset sistem operasi

    ```
    mvn clean spring-boot:run
    ```
  
* Set timezone OS menjadi `Asia/Jakarta` melalui command line (Linux)

    ```
    TZ="Asia/Jakarta" mvn clean spring-boot:run
    ```

* Set timezone dengan argumen JVM

    ```
    MAVEN_OPTS="-Duser.timezone=Asia/Jakarta" mvn clean spring-boot:run
    ```

* Simpan data di database dalam format UTC (tampil di JVM dengan local time)

    ```
    spring.jpa.properties.hibernate.jdbc.time_zone=UTC
    ```

* Insert data jadwal baru ke database. `POST` ke `http://localhost:12345/jadwal`

    ```json
    {
      "nama" : "Jadwal Normal",
      "jamMasuk" : "09:00:00",
      "jamKeluar" : "17:00:00"
    }
    ```
  
    Hasil _insert_ di database

    ```
    MySQL [timezonedb]> select * from jadwal \G
    *************************** 1. row ***************************
    id: c646bbd6-6266-4b86-8997-e84889160e81
    nama: Jadwal Normal
    jam_masuk: 02:00:00
    jam_keluar: 10:00:00
    *************************** 2. row ***************************
    id: j001
    nama: Jadwal Ramadhan
    jam_masuk: 01:00:00
    jam_keluar: 08:00:00
    2 rows in set (0.025 sec)  
    ```