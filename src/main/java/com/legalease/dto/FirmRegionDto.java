package com.legalease.dto;

import lombok.Data;

@Data
public class FirmRegionDto {
    private String id;
    private RegionDto region;
    private boolean booking;
    private String crossBorderCapability;
    private int clientSatisfactionRating;
    private int expertiseAndReputationRating;
}
