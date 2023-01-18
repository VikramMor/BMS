package com.example.BMS.Repository;

import com.example.BMS.Model.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeatEntity, Integer> {
}
