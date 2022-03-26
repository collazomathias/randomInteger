package co.com.sofka.mentoring35.services;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.mentoring35.models.RandomIntegerDTO;
import co.com.sofka.mentoring35.models.RandomIntegerModel;
import co.com.sofka.mentoring35.repositories.RandomIntegerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RandomIntegerService {

    private RandomIntegerRepository randomIntegerRepository;

    @Autowired
    public RandomIntegerService(RandomIntegerRepository randomIntegerRepository) {
        this.randomIntegerRepository = randomIntegerRepository;
    }
    
    public Mono<RandomIntegerModel> post(RandomIntegerDTO randomInteger) {
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

    public Flux<RandomIntegerModel> get() {
        return randomIntegerRepository.findAll();
    }

}
