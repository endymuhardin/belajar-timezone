package com.muhardin.endy.belajar.belajartimezone.dao;

import com.muhardin.endy.belajar.belajartimezone.entity.Jadwal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JadwalDao extends PagingAndSortingRepository<Jadwal, String> {
}
