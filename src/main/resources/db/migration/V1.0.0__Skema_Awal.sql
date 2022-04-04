create table jadwal (
    id varchar(36),
    nama varchar(100) not null,
    jam_masuk time not null,
    jam_keluar time not null,
    primary key (id)
);