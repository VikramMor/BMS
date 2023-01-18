//package com.example.BMS.Service;
//
//import com.example.BMS.Enum.SeatType;
//import com.example.BMS.Model.TheatreSeatEntity;
//import com.example.BMS.Repository.TheatreSeatRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TheatreSeatService {
//
//    @Autowired
//    TheatreSeatRepo theatreSeatRepo;
//    public List<TheatreSeatEntity> createTheatreseats(){
//
//        List<TheatreSeatEntity> seats = new ArrayList<>();
//        TheatreSeatEntity seat1= new TheatreSeatEntity("1A", SeatType.CLASSIC,250);
//        TheatreSeatEntity seat2= new TheatreSeatEntity("2A", SeatType.CLASSIC,250);
//        TheatreSeatEntity seat3= new TheatreSeatEntity("3A", SeatType.CLASSIC,250);
//        TheatreSeatEntity seat4= new TheatreSeatEntity("4A", SeatType.CLASSIC,250);
//        TheatreSeatEntity seat5= new TheatreSeatEntity("5A", SeatType.CLASSIC,250);
//
//        TheatreSeatEntity seat6= new TheatreSeatEntity("1B", SeatType.PLATINUM,350);
//        TheatreSeatEntity seat7= new TheatreSeatEntity("2B", SeatType.PLATINUM,350);
//        TheatreSeatEntity seat8= new TheatreSeatEntity("3B", SeatType.PLATINUM,350);
//        TheatreSeatEntity seat9= new TheatreSeatEntity("4B", SeatType.PLATINUM,350);
//        TheatreSeatEntity seat10= new TheatreSeatEntity("5B", SeatType.PLATINUM,350);
//
//        seats.add(seat1);
//        seats.add(seat2);
//        seats.add(seat3);
//        seats.add(seat4);
//        seats.add(seat5);
//        seats.add(seat6);
//        seats.add(seat7);
//        seats.add(seat8);
//        seats.add(seat9);
//        seats.add(seat10);
//
//        theatreSeatRepo.saveAll(seats);
//
//        return seats;
//    }
//}
