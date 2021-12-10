package com.leverx.dealers;

import com.leverx.dealers.controller.GameController;
import com.leverx.dealers.repository.GameRepository;
import com.leverx.dealers.service.GameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DealersApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameController gameController;
    @MockBean
    private GameServiceImpl gameService;
    @MockBean
    private GameRepository gameRepository;

    @Test
    public void getAllGamesTest() throws Exception {
        this.mockMvc.perform(get("/games")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void addGameTest() throws Exception {
        this.mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content( "{\"name\": \"Ave Maria\"}" )).andExpect(status().isOk());
    }

    @Test
    public void updateGameTest() throws Exception{
        this.mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Sv Petr\"}")).andExpect(status().isOk());
    }

    @Test
    public void findAllGamesMaxRatingTest() throws Exception {
        this.mockMvc.perform(get("/games/rating/min")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void findAllGamesMinRatingTest() throws Exception {
        this.mockMvc.perform(get("/games/rating/max")).andDo(print()).andExpect(status().isOk());
    }

}
