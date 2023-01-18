package com.example.BMS.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Shows")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> showSeatEntityList;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList;
}

