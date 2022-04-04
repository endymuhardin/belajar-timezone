package com.muhardin.endy.belajar.belajartimezone.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity @Data
public class Jadwal {

    @Id
    private String id;

    @NotEmpty
    private String nama;

    @NotNull
    private LocalTime jamMasuk;

    @NotNull
    private LocalTime jamKeluar;
}
