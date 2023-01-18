package com.example.BMS.Service;

import com.example.BMS.Convertor.TheatreConvertor;
import com.example.BMS.Dto.TheatreRequestDto;
import com.example.BMS.Enum.SeatType;
import com.example.BMS.Model.TheatreEntity;
import com.example.BMS.Model.TheatreSeatEntity;
import com.example.BMS.Repository.TheatreRepo;
import com.example.BMS.Repository.TheatreSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    TheatreSeatRepo theatreSeatRepo;

    public String createTheatre(TheatreRequestDto theatreRequestDto) throws Exception {

        try{
            TheatreEntity theatre = TheatreConvertor.convertDtoToEntity(theatreRequestDto);
//            TheatreSeatService theatreSeatService = new TheatreSeatService();
            List<TheatreSeatEntity> theatreSeats = createTheatreseats();
            theatre.setTheatreSeatEntityList(theatreSeats);

            for(TheatreSeatEntity theatreSeat:theatreSeats){
                theatreSeat.setTheatre(theatre);
            }
            theatreRepo.save(theatre);

            return "Theatre added successfully!";
        }
        catch (Exception e){
            throw new Exception("Not able to add requested theatre!!");
        }
    }

    public List<TheatreSeatEntity> createTheatreseats(){

        List<TheatreSeatEntity> seats = new ArrayList<>();
        TheatreSeatEntity seat1= new TheatreSeatEntity("1A", SeatType.CLASSIC,100);
        TheatreSeatEntity seat2= new TheatreSeatEntity("2A", SeatType.CLASSIC,100);
        TheatreSeatEntity seat3= new TheatreSeatEntity("3A", SeatType.CLASSIC,100);
        TheatreSeatEntity seat4= new TheatreSeatEntity("4A", SeatType.CLASSIC,100);
        TheatreSeatEntity seat5= new TheatreSeatEntity("5A", SeatType.CLASSIC,100);

        TheatreSeatEntity seat6= new TheatreSeatEntity("1B", SeatType.PLATINUM,200);
        TheatreSeatEntity seat7= new TheatreSeatEntity("2B", SeatType.PLATINUM,200);
        TheatreSeatEntity seat8= new TheatreSeatEntity("3B", SeatType.PLATINUM,200);
        TheatreSeatEntity seat9= new TheatreSeatEntity("4B", SeatType.PLATINUM,200);
        TheatreSeatEntity seat10= new TheatreSeatEntity("5B", SeatType.PLATINUM,200);

        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        seats.add(seat6);
        seats.add(seat7);
        seats.add(seat8);
        seats.add(seat9);
        seats.add(seat10);

        theatreSeatRepo.saveAll(seats);

        return seats;
    }

    public TheatreEntity getById(int id){
        try {
            TheatreEntity theatre = theatreRepo.findById(id);
            return theatre;
        }
        catch (Exception e){
            throw new RuntimeException("No theatre found with requested id!!");
        }
    }

    public List<TheatreEntity> getAll(){
        try {
            List<TheatreEntity> theatres = theatreRepo.findAll();
            return theatres;
        }
        catch (Exception e){
            throw new RuntimeException("No theatres found in the database!!");
        }
    }
}
