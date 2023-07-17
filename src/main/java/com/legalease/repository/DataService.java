package com.legalease.repository;


import com.legalease.dto.DataDto;
import com.legalease.dto.FirmRegionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles data operations
 */
@Service
public class DataService {

    private List<DataDto> dataList;

    public void setDataList(List<DataDto> dataList) {
        this.dataList = dataList;
    }

    /**
     * Retrieves the list of Firms that match the given region ID.
     *
     * @param regionID The ID of the region to filter the firm rankings.
     * @return A list of Firm objects matching the region ID.
     */
    public List<DataDto> getFirmRankingList(String regionID) {
        ArrayList<DataDto> dataDtos = new ArrayList<>();
        for (DataDto data : dataList) {
            List<FirmRegionDto> firmRegions = data.getFirm().getFirmRegions();
            for (FirmRegionDto region : firmRegions) {
                if (region.getRegion().getId().equals(regionID)) {
                    dataDtos.add(data);
                }
            }
        }
        return dataDtos;
    }
}
