package com.legalease.controller;

import com.legalease.dto.DataDto;
import com.legalease.repository.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LegaleaseControllerTest {

    private LegaleaseController legaleaseController;

    @Mock
    private DataService dataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        legaleaseController = new LegaleaseController(dataService);
    }

    @Test
    void testGetFirmRankingList_WithValidRegionId_ReturnsOkResponse() {
        String regionId = "170";
        List<DataDto> expectedData = new ArrayList<>();
        DataDto data1 = new DataDto();
        DataDto data2 = new DataDto();
        expectedData.add(data1);
        expectedData.add(data2);
        when(dataService.getFirmRankingList(regionId)).thenReturn(expectedData);

        ResponseEntity<Object> response = legaleaseController.getFirmRankingList(regionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedData, response.getBody());
    }

    @Test
    void testGetFirmRankingList_WithInvalidRegionId_ReturnsNotFoundResponse() {
       String regionId = "123";

        ResponseEntity<Object> response = legaleaseController.getFirmRankingList(regionId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Invalid region ID", response.getBody());
    }
}
