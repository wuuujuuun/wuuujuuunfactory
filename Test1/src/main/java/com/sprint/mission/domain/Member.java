package com.sprint.mission.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String memberId;

  private String email;

  @Enumerated(EnumType.STRING)
  private MemberStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  @Builder
  public Member(String name, String memberId, String email, MemberStatus status, Team team) {
    this.name = name;
    this.memberId = memberId;
    this.email = email;
    this.status = status;
    this.team = team;
  }

  public void changeTeam(Team newTeam) {
    this.team = newTeam;
  }

  public void updateStatus(MemberStatus newStatus) {
    this.status = newStatus;
  }
}