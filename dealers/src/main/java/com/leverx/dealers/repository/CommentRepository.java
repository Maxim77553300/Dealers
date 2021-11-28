package com.leverx.dealers.repository;

import com.leverx.dealers.dto.AddCommentRequest;
import com.leverx.dealers.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {


}
