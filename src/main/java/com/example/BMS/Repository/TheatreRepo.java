package com.example.BMS.Repository;

import com.example.BMS.Model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreEntity, Integer> {
    TheatreEntity findById(int id);
    List<TheatreEntity> findAll();

    @Query("select c from TheatreEntity c where c.city =:cityName")
    List<TheatreEntity> findByCity(String cityName);
}
