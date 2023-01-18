package com.example.BMS.Repository;

import com.example.BMS.Model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepo extends JpaRepository<TheatreSeatEntity, Integer> {
}
