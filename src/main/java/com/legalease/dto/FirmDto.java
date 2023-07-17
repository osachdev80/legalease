package com.legalease.dto;

import lombok.Data;
import java.util.List;

@Data
public class FirmDto {
    private String id;
    private String name;
    private String slug;
    private String imageUrl;
    private String websiteUrl;
    private List<BadgeDto> badges;
    private List<AwardDto> awards;
    private List<FirmRegionDto> firmRegions;

}
