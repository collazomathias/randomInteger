package co.com.sofka.mentoring35.controllers;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.mentoring35.models.RandomIntegerDTO;
import co.com.sofka.mentoring35.models.RandomIntegerModel;
import co.com.sofka.mentoring35.repositories.RandomIntegerRepository;
//import co.com.sofka.mentoring35.services.RandomIntegerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/random")
public class RandomIntegerController {

    private RandomIntegerRepository randomIntegerRepository;

    @Autowired
    public RandomIntegerController(RandomIntegerRepository randomIntegerRepository) {
        this.randomIntegerRepository = randomIntegerRepository;
    }

    //private RandomIntegerService randomIntegerService;

    @PostMapping("")
    public Mono<RandomIntegerModel> post(@RequestBody RandomIntegerDTO randomInteger) {
        //return randomIntegerService.post(randomInteger);
        Integer initialNumber = randomInteger.getInitialNumber();
        Integer finalNumber = randomInteger.getFinalNumber();
        Integer columns = randomInteger.getColumns();
        Integer amount = randomInteger.getAmount();
        return Mono.just(new RandomIntegerModel()).map(entity -> {
            entity.setInitialNumber(initialNumber);
            entity.setFinalNumber(finalNumber);
            entity.setColumns(columns);
            entity.setAmount(amount);
            return entity;
        }).map(entity -> {
            IntStream stream = IntStream.generate(() -> {
                return (int)(Math.random() * (finalNumber - initialNumber + 1) + initialNumber);
            });
            int[] numbersList;
            numbersList = stream.limit(amount).toArray();
            entity.setNumbersList(numbersList);
            return entity;
        }).flatMap(randomIntegerRepository::save);
    }

    @GetMapping("")
    public Flux<RandomIntegerModel> get() {
        //return randomIntegerService.get();
        return randomIntegerRepository.findAll();
    }
    
}
