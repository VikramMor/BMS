package com.example.BMS.Repository;

import com.example.BMS.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity, Integer> {
}
