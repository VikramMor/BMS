package com.example.BMS.Service;

import com.example.BMS.Convertor.TheatreConvertor;
import com.example.BMS.RequestDto.TheatreRequestDto;
import com.example.BMS.Enum.SeatType;
import com.example.BMS.Model.TheatreEntity;
import com.example.BMS.Model.TheatreSeatEntity;
import com.example.BMS.Repository.TheatreRepo;
import com.example.BMS.Repository.TheatreSeatRepo;
import com.example.BMS.ResponseDto.TheatreResponseDto;
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

    public TheatreResponseDto getById(int id){
        try {
            TheatreEntity theatre = theatreRepo.findById(id);
            TheatreResponseDto theatreResponseDto = TheatreConvertor.convertEntityToDto(theatre);
            return theatreResponseDto;
        }
        catch (Exception e){
            throw new RuntimeException("No theatre found with requested id!!");
        }
    }

    public List<TheatreResponseDto> getByCity(String cityName){
        try {
            List<TheatreEntity> theatres = theatreRepo.findByCity(cityName);
            System.out.println(theatres.size());
            List<TheatreResponseDto> dtoList = new ArrayList<>();

            for(TheatreEntity theatre : theatres){
                TheatreResponseDto theatreResponseDto = TheatreConvertor.convertEntityToDto(theatre);
                dtoList.add(theatreResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("No theatre found in requested City!!");
        }
        finally {
            List<TheatreEntity> theatres = theatreRepo.findByCity(cityName);
            System.out.println(theatres.size());
        }
    }

    public List<TheatreResponseDto> getAll(){
        try {
            List<TheatreEntity> theatres = theatreRepo.findAll();
            List<TheatreResponseDto> dtoList = new ArrayList<>();

            for(TheatreEntity theatre : theatres){
                TheatreResponseDto theatreResponseDto = TheatreConvertor.convertEntityToDto(theatre);
                dtoList.add(theatreResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("No theatres found in the database!!");
        }
    }
}
