package com.devBARROS.dslist.repositories;

import com.devBARROS.dslist.entities.Game;
import com.devBARROS.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
