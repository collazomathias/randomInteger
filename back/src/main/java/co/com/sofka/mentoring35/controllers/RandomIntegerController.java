package co.com.sofka.mentoring35.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.mentoring35.models.RandomIntegerDTO;
import co.com.sofka.mentoring35.models.RandomIntegerModel;
import co.com.sofka.mentoring35.services.RandomIntegerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/randomInteger")
public class RandomIntegerController {

    private RandomIntegerService randomIntegerService;

    @PostMapping
    public Mono<RandomIntegerModel> post(@RequestBody RandomIntegerDTO randomInteger) {
        return randomIntegerService.post(randomInteger);
    }

    @GetMapping
    public Flux<RandomIntegerModel> get() {
        return randomIntegerService.get();
    }
    
}
