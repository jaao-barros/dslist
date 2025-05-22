package com.devBARROS.dslist.services;

import com.devBARROS.dslist.dto.GameDTO;
import com.devBARROS.dslist.dto.GameListDTO;
import com.devBARROS.dslist.dto.GameMinDTO;
import com.devBARROS.dslist.entities.Game;
import com.devBARROS.dslist.entities.GameList;
import com.devBARROS.dslist.repositories.GameListRepository;
import com.devBARROS.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
