package com.leverx.dealers.repository;

import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.dto.RatingResultDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByUserId(Integer userId);

    List<Comment> findCommentByGameObjectId(Integer gameObjectId);

    Optional<Comment> findCommentById(Integer comment);

    @Query(value = "SELECT user.id as userId,first_name as firstName, last_name as lastName, avg(rating) as rating FROM user LEFT JOIN" +
            " (SELECT game_object.user_id, game_object.id, avg(rating) as rating " +
            " FROM comment LEFT JOIN game_object ON comment.game_object_id = game_object.id GROUP BY game_object.id)" +
            " as nested ON user.id = nested.user_id group by user.id ORDER BY rating DESC",nativeQuery = true)
    List<RatingResultDto> getRatingGameObjectList();


}
