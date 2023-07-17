package com.legalease.repository;

import com.legalease.dto.DataDto;
import com.legalease.dto.FirmDto;
import com.legalease.dto.FirmRegionDto;
import com.legalease.dto.RegionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceTest {

    private DataService dataService;

    @BeforeEach
    void setUp() {
        dataService = new DataService();
    }

    @Test
    void testGetFirmRankingList_WithMatchingRegionID_ReturnsMatchingFirmList() {
        String regionId = "170";
        List<DataDto> dataList = createTestData();
        dataService.setDataList(dataList);

        List<DataDto> result = dataService.getFirmRankingList(regionId);

        assertEquals(2, result.size());
        assertEquals("19859", result.get(0).getId());
        assertEquals("36274", result.get(1).getId());
    }

    @Test
    void testGetFirmRankingList_WithNonMatchingRegionID_ReturnsEmptyList() {
        String regionId = "123";
        List<DataDto> dataList = createTestData();
        dataService.setDataList(dataList);

        List<DataDto> result = dataService.getFirmRankingList(regionId);

        assertEquals(0, result.size());
    }

    private List<DataDto> createTestData() {
        List<DataDto> dataList = new ArrayList<>();

        // Create FirmRegionDto for London region
        FirmRegionDto londonRegion = new FirmRegionDto();
        RegionDto regionDto = new RegionDto();
        regionDto.setId("170");
        regionDto.setName("London");
        londonRegion.setRegion(regionDto);

        // Create FirmDto for Allen & Overy firm with London region
        FirmDto allenOveryFirm = new FirmDto();
        allenOveryFirm.setFirmRegions(Collections.singletonList(londonRegion));

        // Create DataDto with Allen & Overy firm
        DataDto data1 = new DataDto();
        data1.setId("19859");
        data1.setFirm(allenOveryFirm);

        // Create FirmDto for BDB Pitmans firm with London region
        FirmDto bdbPitmansFirm = new FirmDto();
        bdbPitmansFirm.setFirmRegions(Collections.singletonList(londonRegion));

        // Create DataDto with BDB Pitmans firm
        DataDto data2 = new DataDto();
        data2.setId("36274");
        data2.setFirm(bdbPitmansFirm);

        dataList.add(data1);
        dataList.add(data2);
        return dataList;
    }
}
