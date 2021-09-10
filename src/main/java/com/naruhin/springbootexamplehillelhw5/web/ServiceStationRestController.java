package com.naruhin.springbootexamplehillelhw5.web;

import com.naruhin.springbootexamplehillelhw5.dto.ServiceStationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;

@Tag(name = "Service Station", description = "Car API")

public interface ServiceStationRestController {
    @Operation(summary = "Add a new Service Station", description = "endpoint for creating an entity", tags = {"Service Station"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Service Station created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "MService Station already exists")})
    ServiceStationDTO saveServiceStation(ServiceStationDTO serviceStationDTO, long addressId);

    @Operation(summary = "Get list of Service Stations", description = "endpoint for getting list of entities", tags = {"Service Station"})
    Collection<ServiceStationDTO> getAllServiceStations();

    @Operation(summary = "Remove all Service Stations", description = "endpoint for deleting an entity", tags = {"Service Station"})
    void removeAllServiceStations();

    @Operation(summary = "Update a Service Station", description = "endpoint for updating an entity", tags = {"Service Station"})
    ServiceStationDTO updateServiceStation(long id, ServiceStationDTO serviceStationDTO);

}
