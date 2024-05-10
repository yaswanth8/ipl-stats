package com.ipl.iplstats.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.iplstats.domain.Player;
import com.ipl.iplstats.dto.PlayerDto;

import java.util.List;

public class ConvertorUtil {

    public static List<PlayerDto> toDto(List<Player> players){
    return players.stream().map(ConvertorUtil::toDto).toList();
    }
    public static List<Player> toEntity(List<PlayerDto> playerDtos){
        return playerDtos.stream().map(ConvertorUtil::toEntity).toList();
    }
    public static PlayerDto toDto(Player player){
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.convertValue(player,PlayerDto.class);

    }

    public static Player toEntity(PlayerDto playerDto){
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.convertValue(playerDto,Player.class);
    }
}
