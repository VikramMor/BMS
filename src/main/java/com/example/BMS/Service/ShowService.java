package com.example.BMS.Service;

import com.example.BMS.Convertor.ShowConvertor;
import com.example.BMS.Dto.ShowRequestDto;
import com.example.BMS.Model.*;
import com.example.BMS.Repository.MovieRepo;
import com.example.BMS.Repository.ShowRepo;
import com.example.BMS.Repository.ShowSeatRepo;
import com.example.BMS.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    ShowRepo showRepo;

    @Autowired
    ShowSeatRepo showSeatRepo;

    public String createShow(ShowRequestDto showRequestDto){
        ShowEntity show = ShowConvertor.convertDtoToEntity(showRequestDto);

        MovieEntity movie = movieRepo.findByName(showRequestDto.getMovieName());

        TheatreEntity theatre = theatreRepo.findById(showRequestDto.getTheatreId());
        show.setTheatreEntity(theatre);
        show.setMovieEntity(movie);

//        movie.getShowEntityList().add(show);
//        theatre.getListOfShows().add(show);

        List<ShowSeatEntity> showSeats = createShowSeats(theatre.getTheatreSeatEntityList());

        show.setShowSeatEntityList(showSeats);

        for(ShowSeatEntity seat: showSeats){
            seat.setShow(show);
        }
//        movieRepo.save(movie);
//        theatreRepo.save(theatre);
        showRepo.save(show);

        return "Show added successfully!";
    }

    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeats){

        List<ShowSeatEntity> showSeats = new ArrayList<>();

        for(TheatreSeatEntity theatreSeat:theatreSeats){
            ShowSeatEntity seats = ShowSeatEntity.builder().seatNo(theatreSeat.getSeatNo()).
                                        seatType(theatreSeat.getSeatType()).build();
            showSeats.add(seats);
        }
        showSeatRepo.saveAll(showSeats);

        return showSeats;
    }
}
