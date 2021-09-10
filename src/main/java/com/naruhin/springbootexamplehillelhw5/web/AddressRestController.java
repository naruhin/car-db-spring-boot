package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.dto.AddressDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Address", description = "Car API")

public interface AddressRestController {

    @Operation(summary = "Add a new address", description = "endpoint for creating an entity", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Address created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Address already exists")})
    AddressDTO saveAddress(AddressDTO addressDTO);

    @Operation(summary = "Get list of addresses", description = "endpoint to get list of entities", tags = {"Address"})
    List<AddressDTO> getAllAddresses();

    @Operation(summary = "Remove all addresses", description = "remove all entities", tags = {"Address"})
    void removeAllAddresses();

    @Operation(summary = "Update a cars", description = "endpoint to update entity", tags = {"Address"})
    AddressDTO updateAddress(long id, AddressDTO addressDTO);
}
