package com.example.BMS.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="ticket")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allotedSeats;

    private int amount;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> showSeatEntityList;
}

