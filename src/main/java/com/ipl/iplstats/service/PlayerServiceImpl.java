package com.ipl.iplstats.service;

import com.ipl.iplstats.dao.PlayerRepo;
import com.ipl.iplstats.domain.Player;
import com.ipl.iplstats.dto.CountryCountRecord;
import com.ipl.iplstats.dto.PlayerDto;
import com.ipl.iplstats.dto.TeamAmountRecord;
import com.ipl.iplstats.dto.TeamCountTotalAmountRecord;
import com.ipl.iplstats.migration.ConvertorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepo playerRepo;
    @Override
    public List<PlayerDto> getPlayersOf(String team) {
        List<Player> players = playerRepo.findPlayerDetailsByTeam(team);
        List<PlayerDto> playerDto = ConvertorUtil.toDto(players);
        log.info("Total players found for team : {} is : {} ",team,playerDto.size());
        return playerDto;
    }

    @Override
    public List<String> getTeams() {
        return playerRepo.findTeamNames();
    }

    @Override
    public List<PlayerDto> getPlayersByRole(String team, String role) {
        List<Player> players=playerRepo.findByTeamAndRole(team,role);
        log.info("Total players found for team : {} and role : {} is : {} ",team,role,players.size());
        return ConvertorUtil.toDto(players);

    }

    @Override
    public List<PlayerDto> getPlayersByCountry(String country) {

        List<Player> players=playerRepo.findByCountry(country);
        log.info("Total players found for country : {}  ",country);
        return ConvertorUtil.toDto(players);
    }

    @Override
    public List<PlayerDto> getBasePricePlayers() {
        double basePrice=2000000;
        return playerRepo.findByAmountEquals(basePrice);
    }

    @Override
    public List<CountryCountRecord> getPlayerCountByCountry() {
        return null;
    }

    @Override
    public List<TeamAmountRecord> getTeamAmount() {
        return null;
    }

    @Override
    public List<TeamCountTotalAmountRecord> getTeamCountTotalAmount() {
        return playerRepo.findTeamCountTotalAmount();
    }

    @Override
    public List<PlayerDto> getTopNPlayers(int n) {
        return null;
    }

    @Override
    public List<PlayerDto> getTopPaidPlayersOfEachTeam() {
        List<Player> player =  playerRepo.getTopPaidPlayersOfEachTeam();
        return ConvertorUtil.toDto(player);
    }

    @Override
    public List<PlayerDto> getTopPaidPlayersOfEachCountry() {
        return null;
    }
}
