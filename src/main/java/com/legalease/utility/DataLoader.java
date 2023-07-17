package com.legalease.utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.legalease.repository.DataService;
import com.legalease.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * DataLoader is a component that loads data from a JSON file into the DataService.
 * It implements CommandLineRunner to run the data loading process during application startup.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final DataService dataService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public DataLoader(DataService dataService, ResourceLoader resourceLoader) {
        this.dataService = dataService;
        this.resourceLoader = resourceLoader;
    }


    /**
     * Runs the data loading process during application startup.
     *
     * @param args The command line arguments.
     */
    @Override
    public void run(String... args) {
        Resource resource = resourceLoader.getResource("classpath:legalease-code-test-api.json");
        try (InputStream inputStream = resource.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<DataDto> dataList = objectMapper.readValue(inputStream, new TypeReference<List<DataDto>>() {});
            dataService.setDataList(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


