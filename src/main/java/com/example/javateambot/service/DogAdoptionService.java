package com.example.javateambot.service;

import com.example.javateambot.entity.AdoptedDogs;
import com.example.javateambot.entity.Users;
import com.example.javateambot.repository.DogAdoptionRepository;
import com.example.javateambot.repository.DogsInShelterRepository;
import com.example.javateambot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class DogAdoptionService {

    public DogAdoptionService(AdoptedDogs adoptedDogs, DogsInShelterRepository dogsInShelterRepository, UsersRepository usersRepository, DogAdoptionRepository dogAdoptionRepository) {
        this.adoptedDogs = adoptedDogs;
        this.dogsInShelterRepository = dogsInShelterRepository;
        this.usersRepository = usersRepository;
        this.dogAdoptionRepository = dogAdoptionRepository;
    }

    @Autowired
    AdoptedDogs adoptedDogs;

    @Autowired
    DogsInShelterRepository dogsInShelterRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DogAdoptionRepository dogAdoptionRepository;


// работает с этим кодом, но в нем не красиво добавляется в свагере

    public AdoptedDogs adoptionDog2(Long userID, Long dogId, AdoptedDogs adoptedDogs) {

        if (dogsInShelterRepository.findById(dogId).isPresent()||usersRepository.findById(userID).isPresent()){
            adoptedDogs.setIdUser(userID);
            adoptedDogs.setIdDog(dogId);
            adoptedDogs.setLastDateProbationPeriod(LocalDate.now().plusDays(30));

        }

        return dogAdoptionRepository.save(adoptedDogs);
    }

//    public void editAnimalInShelter(AnimalsInHouse animal,String report) {
//        animal =         animalsInHouseRepository.findByIdUser(getId("222"));
//
//        animal.setLastText(report);
//        animalsInHouseRepository.save(animal);
//    }
//    public Long getId(String number) {
//        Long idUser = usersRepository.findByNumberUser(number).getIdUser();
//
//        return idUser;
//    }

    public Boolean checkChatId(Long chatId) {
        if (Objects.equals(usersRepository.findByChatId(chatId).getChatId(), chatId)) {
            return true ;
        } else return false;
    }

    public Users findUserByChatId(long chatId) {
        return usersRepository.findByChatId(chatId);
    }
}
