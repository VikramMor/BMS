package com.example.BMS.Repository;

import com.example.BMS.Model.TheatreEntity;
import com.example.BMS.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreEntity, Integer> {
    public TheatreEntity findById(int id);
    public List<TheatreEntity> findAll();
}
