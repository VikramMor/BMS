package com.example.BMS.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="Theatre")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;

    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<TheatreSeatEntity> theatreSeatEntityList;

    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
//    @JsonManagedReference
    List<ShowEntity> listOfShows;
}
