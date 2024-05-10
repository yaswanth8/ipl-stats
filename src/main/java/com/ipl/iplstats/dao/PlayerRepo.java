package com.ipl.iplstats.dao;

import com.ipl.iplstats.domain.Player;
import com.ipl.iplstats.dto.CountryCountRecord;
import com.ipl.iplstats.dto.PlayerDto;
import com.ipl.iplstats.dto.TeamCountTotalAmountRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepo extends JpaRepository<Player, UUID> {


    @Query("select p from Player p where p.team=:team")
    List<Player> findPlayerDetailsByTeam(@Param("team") String team);

    @Query("select distinct(p.team) from Player p")
    List<String> findTeamNames();

    List<Player> findByTeamAndRole(String team, String role);

    List<Player> findByCountry(String country);

    List<PlayerDto> findByAmountEquals(double basePrice);

    @Query("select new com.ipl.iplstats.dto.TeamCountTotalAmountRecord(p.team,count(p),sum(p.amount)) from Player p group by p.team order by sum(p.amount) desc")
    List<TeamCountTotalAmountRecord> findTeamCountTotalAmount();


    @Query(value = """
            select id,name,role,amount,team,country from(
                select id,name,role,amount,team,country, dense_rank()
                over(partition by team order by amount desc) rnk from player) tmp
                where tmp.rnk=1;
            """,nativeQuery = true)
    List<Player> getTopPaidPlayersOfEachTeam();



}
