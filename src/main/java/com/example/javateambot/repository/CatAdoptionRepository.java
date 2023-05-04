package com.example.javateambot.repository;

import com.example.javateambot.entity.AdoptedCats;
import com.example.javateambot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CatAdoptionRepository extends JpaRepository<AdoptedCats, Long> {

        Long findByUsersChatId (Users users);
        AdoptedCats findByLastDateProbationPeriod (LocalDate localDate);
//        @Query("SELECT e FROM AdoptedCats e WHERE e.lastDateProbationPeriod = :date")
//        List<AdoptedCats> findByDate(@Param("date") LocalDate date);



}