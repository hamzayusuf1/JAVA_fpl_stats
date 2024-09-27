package com.pl.premier_stats.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    void deleteByPlayerName(String playerName);
    Optional<Player> findByPlayerName(String name);
}
