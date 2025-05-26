package com.devBARROS.dslist.services;

import com.devBARROS.dslist.dto.GameDTO;
import com.devBARROS.dslist.dto.GameListDTO;
import com.devBARROS.dslist.dto.GameMinDTO;
import com.devBARROS.dslist.entities.Game;
import com.devBARROS.dslist.entities.GameList;
import com.devBARROS.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i<= max; i++) {
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(), i);
        }
    }
}
