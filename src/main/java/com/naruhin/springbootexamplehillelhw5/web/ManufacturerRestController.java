package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.domain.Dealer;
import com.naruhin.springbootexamplehillelhw5.domain.Manufacturer;
import com.naruhin.springbootexamplehillelhw5.repository.ManufacturerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerRestController {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerRestController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }


    //Операция сохранения производителя в базу данных
    @PostMapping("/manufacturers")
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer saveManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    //Получение списка производителей
    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    //Удаление всех производителей
    @DeleteMapping("/manufacturers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllManufacturers() {
        manufacturerRepository.deleteAll();
    }

    //Обновление производителя
    @PutMapping("/manufacturers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Manufacturer updateAddress(@PathVariable("id") long id, @RequestBody Manufacturer manufacturer) {
        return manufacturerRepository.findById(id)
                .map(entity -> {
                    entity.setName(manufacturer.getName());
                    return manufacturerRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer with id = Not found"));
    }
}
