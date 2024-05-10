package com.ipl.iplstats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="player")
@Getter
@Setter
public class Player {

    @Id
    private UUID id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double amount;

    @PrePersist
    public void onPrePersist(){
        this.id=UUID.randomUUID();
    }
}
