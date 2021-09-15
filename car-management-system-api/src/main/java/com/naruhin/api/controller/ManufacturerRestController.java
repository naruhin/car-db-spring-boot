package com.naruhin.api.controller;

import com.naruhin.api.dto.ManufacturerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@Tag(name = "Manufacturer", description = "Car API")

public interface ManufacturerRestController {
    @Operation(summary = "Add a new manufacturer", description = "endpoint for creating an entity", tags = {"Manufacturer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Manufacturer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Manufacturer already exists")})
    ManufacturerDTO saveManufacturer(ManufacturerDTO manufacturerDTO, long addressId);

    @Operation(summary = "Get list of manufacturers", description = "endpoint for getting list of entities", tags = {"Manufacturer"})
    Collection<ManufacturerDTO> getAllManufacturers();

    @Operation(summary = "Remove all manufacturers", description = "endpoint for deleting an entity", tags = {"Manufacturer"})
    void removeAllManufacturers();

    @Operation(summary = "Update a manufacturer", description = "endpoint for updating an entity", tags = {"Manufacturer"})
    ManufacturerDTO updateManufacturer(long id, ManufacturerDTO manufacturerDTO);

}
