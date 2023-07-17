package com.legalease.controller;

import com.legalease.repository.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LegaleaseController {

    private final DataService dataService;

    @Autowired
    public LegaleaseController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/checkRegion/{regionID}")
    public ResponseEntity<Object> getFirmRankingList(@PathVariable String regionID) {
        log.info("Entering getFirmRankingList with region {}", regionID);
        if (!regionID.equals("170")) {
            return new ResponseEntity<>("Invalid region ID", HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(dataService.getFirmRankingList(regionID), HttpStatus.OK);
        }
    }

