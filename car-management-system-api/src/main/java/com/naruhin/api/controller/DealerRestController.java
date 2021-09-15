package com.naruhin.api.controller;

import com.naruhin.api.dto.DealerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@Tag(name = "Dealer", description = "Car API")

public interface DealerRestController {

    @Operation(summary = "Add a new dealer", description = "endpoint for creating an entity", tags = {"Dealer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dealer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Dealer already exists")})
    DealerDTO saveAddress(DealerDTO dealerDTO, long addressId);

    @Operation(summary = "Get list of dealers", description = "endpoint for getting list of entities", tags = {"Dealer"})
    Collection<DealerDTO> getAllDealers();

    @Operation(summary = "Remove all dealers", description = "endpoint for deleting an entity", tags = {"Dealer"})
    void removeAllDealers();

    @Operation(summary = "Update a dealer", description = "endpoint for updating an entity", tags = {"Dealer"})
    DealerDTO updateDealer(long id, DealerDTO dealerDTO);
}
