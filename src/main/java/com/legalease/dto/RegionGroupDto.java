package com.legalease.dto;

import lombok.Data;

@Data
public class RegionGroupDto {
    private String id;
    private String name;
    private String slug;
    private RegionAreaDto regionArea;


}
