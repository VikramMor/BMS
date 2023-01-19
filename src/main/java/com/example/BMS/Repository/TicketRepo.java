package com.example.BMS.Repository;

import com.example.BMS.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {
}
