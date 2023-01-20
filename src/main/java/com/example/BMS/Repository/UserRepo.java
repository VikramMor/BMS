package com.example.BMS.Repository;
import com.example.BMS.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    public List<UserEntity> findByName(String name);
//    @Query(value = "Select * from users ORDER BY id")
    public List<UserEntity> findAll();

    @Query("select u from UserEntity u where u.mobile =:mobileNo")
    public UserEntity findByMobile(String mobileNo);
}