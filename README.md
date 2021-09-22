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