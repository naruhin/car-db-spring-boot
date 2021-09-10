package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.dto.CarDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@Tag(name = "Car", description = "Car API")

public interface CarRestController {

    @Operation(summary = "Add a new car", description = "endpoint for creating an entity", tags = {"Car"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Car created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Car already exists")})
    CarDTO saveCar(CarDTO carDTO, long manufacturerId);

    @Operation(summary = "Get list of cars", description = "endpoint to get list of entities", tags = {"Car"})
    Collection<CarDTO> getAllCars();

    @Operation(summary = "Get car by ID", description = "endpoint to get an entity by ID", tags = {"Car"})
    CarDTO getCarById(long id);

    @Operation(summary = "Update car", description = "endpoint for updating an entity", tags = {"Car"})
    CarDTO updateCar(long id, CarDTO carDTO);

    @Operation(summary = "Update car's dealer", description = "endpoint for updating dealer", tags = {"Car"})
    CarDTO updateCarDealer(long carId, long dealerId);

    @Operation(summary = "Update car's service station", description = "endpoint for updating service station", tags = {"Car"})
    CarDTO updateCarServiceStation(long carId, long serviceStationId);

    @Operation(summary = "Delete all cars", description = "endpoint for deleting all entities", tags = {"Car"})
    void removeAllCars();

    @Operation(summary = "Delete car by ID", description = "endpoint for deleting an entity by ID", tags = {"Car"})
    void removeCarsById(long id);
}
