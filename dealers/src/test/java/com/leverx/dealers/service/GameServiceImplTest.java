package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddGameRequest;
import com.leverx.dealers.entity.Game;
import com.leverx.dealers.repository.GameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameServiceImplTest {

    @Autowired
    private GameServiceImpl gameService;

    @MockBean
    private GameRepository gameRepository;

    @Test
    public void addGame() {
        Game game = new Game();
        AddGameRequest addGameRequest = new AddGameRequest();
        boolean isGameCreated = gameService.addGame(addGameRequest);

        Assert.assertTrue(isGameCreated);
    }
}