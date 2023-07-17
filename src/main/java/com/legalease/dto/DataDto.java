package com.legalease.dto;

import lombok.Data;

@Data
public class DataDto {
    private String id;
    private FirmDto firm;
    private String trend;
    private boolean diversity;
    private String tier;
    private int position;
}

