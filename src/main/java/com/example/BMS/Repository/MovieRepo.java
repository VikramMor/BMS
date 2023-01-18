package com.example.BMS.Repository;
import com.example.BMS.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {
    public MovieEntity findByName(String name);
    public List<MovieEntity> findAll();
}
