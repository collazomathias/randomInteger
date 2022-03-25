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

        return Mono.just(new RandomIntegerModel()).map(entity -> {
            entity.setInitialNumber(initialNumber);
            entity.setFinalNumber(finalNumber);
            entity.setColumns(columns);
            return entity;
        }).map(entity -> {
            IntStream stream = IntStream.generate(() -> {
                return numerorandomEntreXY(initialNumber, finalNumber);
            });
            int[] numbersList;
            numbersList = stream.limit(finalNumber - initialNumber + 1).toArray();
            entity.setNumbersList(numbersList);
            return entity;
        }).flatMap(randomIntegerRepository::save);
    }
    
    public int numerorandomEntreXY(int x, int y) {
        return (int) (Math.random() * (y - x + 1) + x);
    }

    public Flux<RandomIntegerModel> get() {
        return randomIntegerRepository.findAll();
    }

}
