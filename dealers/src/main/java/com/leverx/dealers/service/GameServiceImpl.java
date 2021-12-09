package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.dto.FilterResultGameDto;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.exceptions.NoSuchException;
import com.leverx.dealers.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;


    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public boolean addGame(AddGameRequest addGameRequest) {
        Game gameFromDb = gameRepository.findByName(addGameRequest.getName());
        if(gameFromDb != null){
            return false;
        }
        gameRepository.save(mapAddGameRequestToGame(addGameRequest));
        return true;
    }

    @Override
    public void updateGame(AddGameRequest addGameRequest,Integer id) {
        Game game = gameRepository.findById(id).orElseThrow(NoSuchException::new);
        game.setName(addGameRequest.getName());
        gameRepository.save(game);
    }

    @Override
    public List<FilterResultGameDto> findAllGamesByMinRating(){
        List<FilterResultGameDto> filterResultGameDtoList = gameRepository.filterGamesByMinRating();
        return filterResultGameDtoList;
    }

    @Override
    public List<FilterResultGameDto> findAllGamesByMaxRating(){
        List<FilterResultGameDto> filterResultGameDtoList = gameRepository.filterGamesByMaxRating();
        return filterResultGameDtoList;
    }

    private Game mapAddGameRequestToGame(AddGameRequest addGameRequest) {
        Game game = new Game();
        game.setName(addGameRequest.getName());
        return game;
    }
}
