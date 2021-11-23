package com.example.rascalserver.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
public class AccountToTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "number")
    private Integer number;
}
