package com.devBARROS.dslist.repositories;

import com.devBARROS.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
