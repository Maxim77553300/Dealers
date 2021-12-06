package com.leverx.dealers.repository;

import com.leverx.dealers.entity.Comment;
import com.leverx.dealers.entity.GameObject;
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

    //gameObject_id,rating, --??
    @Query(value = "FROM Comment comment ORDER BY comment.rating DESC ")
    List<Comment> getRatingGameObjectList();


}
