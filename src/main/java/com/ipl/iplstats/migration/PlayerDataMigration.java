package com.ipl.iplstats.migration;

import com.ipl.iplstats.dao.PlayerRepo;
import com.ipl.iplstats.domain.Player;
import com.ipl.iplstats.dto.PlayerDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlayerDataMigration {

    private final PlayerRepo playerRepo;

    @Transactional
    public List<Player> migrate(){
        List<PlayerDto> playerDtos= getPlayerDetails();
        List<Player> players=ConvertorUtil.toEntity(playerDtos);
        log.info("Total records to be migrated : {} ", players.size());
        playerRepo.deleteAll();
        players = playerRepo.saveAll(players);
        log.info("Total records migrated : {} ", players.size());
        return players;
    }

    private List<PlayerDto> getPlayerDetails(){
        return JsonReaderUtil.readJsonFile("/players.json");
    }
}
