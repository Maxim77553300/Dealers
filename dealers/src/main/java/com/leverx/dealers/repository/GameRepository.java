package com.leverx.dealers.repository;

import com.leverx.dealers.dto.FilterResultGameDto;
import com.leverx.dealers.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT game.id as gameId,name , avg(rating) as gameRating FROM game LEFT JOIN " +
            "(SELECT game_object.game_id, game_object.id, avg(rating) as rating " +
            " FROM comment LEFT JOIN game_object ON comment.game_object_id = game_object.id GROUP BY game_object.id)" +
            " as nested ON game.id = nested.game_id group by game.id ORDER BY gameRating ", nativeQuery = true)
    List<FilterResultGameDto> filterGamesByMinRating();

    @Query(value = "SELECT game.id as gameId,name , avg(rating) as gameRating FROM game LEFT JOIN " +
            "(SELECT game_object.game_id, game_object.id, avg(rating) as rating " +
            " FROM comment LEFT JOIN game_object ON comment.game_object_id = game_object.id GROUP BY game_object.id)" +
            " as nested ON game.id = nested.game_id group by game.id ORDER BY gameRating DESC ", nativeQuery = true)
    List<FilterResultGameDto> filterGamesByMaxRating();
}
