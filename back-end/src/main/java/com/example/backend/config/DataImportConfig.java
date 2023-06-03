package com.example.backend.config;

import com.example.backend.model.School;
import com.example.backend.service.HeadmasterService;
import com.example.backend.service.SchoolService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataImportConfig {

    private final SchoolService schoolService;
    private final HeadmasterService headmasterService;

    @Bean
    CommandLineRunner fillDatabase() {
        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return args -> {
//            try {
            schoolService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/schools.json"), new TypeReference<>() {
            }));
            headmasterService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/headmasters.json"), new TypeReference<>() {
            }));

            School school = schoolService.getSchoolById(1);
            school.setHeadmaster(headmasterService.getHeadmasterById(1));
            schoolService.save(school);

            log.error("" + headmasterService.getHeadmasterById(1).getSchool().getAddress());

            log.info("Entities saved successfully");
//            } catch (IOException e) {
//                log.error("Unable to save entities");
//            }
        };
    }
}
