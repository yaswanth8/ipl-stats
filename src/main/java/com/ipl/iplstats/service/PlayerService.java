package com.ipl.iplstats.service;

import com.ipl.iplstats.dto.CountryCountRecord;
import com.ipl.iplstats.dto.PlayerDto;
import com.ipl.iplstats.dto.TeamAmountRecord;
import com.ipl.iplstats.dto.TeamCountTotalAmountRecord;

import java.util.List;

public interface PlayerService {

    List<PlayerDto> getPlayersOf(String team);
    List<String> getTeams();
    List<PlayerDto> getPlayersByRole(String team,String role);
    List<PlayerDto> getPlayersByCountry(String country);
    List<PlayerDto> getBasePricePlayers(); // base price is less than 20,00,000
    List<CountryCountRecord> getPlayerCountByCountry();
    List<TeamAmountRecord> getTeamAmount();
    List<TeamCountTotalAmountRecord> getTeamCountTotalAmount();
    List<PlayerDto> getTopNPlayers(int n);
    List<PlayerDto> getTopPaidPlayersOfEachTeam();
    List<PlayerDto> getTopPaidPlayersOfEachCountry();








}
