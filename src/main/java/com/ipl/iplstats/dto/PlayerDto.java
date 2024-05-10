package com.ipl.iplstats.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PlayerDto {


    private UUID id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double amount;
}
