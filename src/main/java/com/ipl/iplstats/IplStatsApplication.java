package com.ipl.iplstats;

import com.ipl.iplstats.domain.Player;
import com.ipl.iplstats.dto.PlayerDto;
import com.ipl.iplstats.dto.TeamCountTotalAmountRecord;
import com.ipl.iplstats.migration.PlayerDataMigration;
import com.ipl.iplstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IplStatsApplication implements CommandLineRunner{


	@Autowired
	private PlayerDataMigration playerDataMigration;

	@Autowired
	private PlayerService playerService;



	public static void main(String[] args) {
		SpringApplication.run(IplStatsApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");

		/*List<Player> players= playerDataMigration.migrate();

		players.forEach(p -> {
			System.out.println(p.getId() + " : "+p.getName() + " : "+p.getRole() + " : "+p.getCountry() + " : "+p.getTeam() + " : "+p.getAmount());
		});*/

		List<PlayerDto> playerDtos= playerService.getPlayersOf("RCB");
		playerDtos.forEach(p -> {
			System.out.println(p.getId() + " : "+p.getName() + " : "+p.getRole() + " : "+p.getCountry() + " : "+p.getTeam() + " : "+p.getAmount());
		});

		System.out.println("Teams : "+playerService.getTeams());

		List<PlayerDto> playerDtosByCountry= playerService.getPlayersByCountry("India");
		playerDtosByCountry.forEach(p -> {
			System.out.println(p.getId() + " : "+p.getName() + " : "+p.getRole() + " : "+p.getCountry() + " : "+p.getTeam() + " : "+p.getAmount());
		});



		List<TeamCountTotalAmountRecord> teamCountTotalAmountRecords = playerService.getTeamCountTotalAmount();
		teamCountTotalAmountRecords.forEach(t->{
			System.out.println(t.team() + " : "+t.count() + " : "+t.totalAmount());
		});


		List<PlayerDto> topPaidPlayersOfEachTeam = playerService.getTopPaidPlayersOfEachTeam();
		topPaidPlayersOfEachTeam.forEach(p->{
			System.out.println(p.getId() + " : "+p.getName() + " : "+p.getRole() + " : "+p.getCountry() + " : "+p.getTeam() + " : "+p.getAmount());
		});
	}
}
