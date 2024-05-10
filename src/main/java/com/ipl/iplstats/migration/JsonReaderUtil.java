package com.ipl.iplstats.migration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.iplstats.dto.PlayerDto;

import java.util.List;

public class JsonReaderUtil {

    public static List<PlayerDto> readJsonFile(String fileName){
        ObjectMapper objectMapper=new ObjectMapper();

        try{
            return objectMapper.readValue(JsonReaderUtil.class.getResourceAsStream(fileName), new TypeReference<List<PlayerDto>>() {
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return List.of();
    }
}
