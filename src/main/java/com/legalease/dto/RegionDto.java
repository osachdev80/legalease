package com.legalease.dto;

import lombok.Data;

@Data
public class RegionDto {
    private String id;
    private String name;
    private String slug;
    private RegionGroupDto regionGroup;


}
