package com.ipl.iplstats.web;


import com.ipl.iplstats.dto.PlayerDto;
import com.ipl.iplstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ipl")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    @GetMapping("/teams")
    public ResponseEntity<List<String>> getTeams(){
        return ResponseEntity.ok(playerService.getTeams());
    }

}
