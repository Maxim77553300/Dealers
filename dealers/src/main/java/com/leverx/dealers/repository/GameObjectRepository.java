package com.leverx.dealers.repository;

import com.leverx.dealers.entity.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameObjectRepository extends JpaRepository<GameObject, Integer> {

    List<GameObject> findByGameId(Integer gameId);

    List<GameObject> findByUserId(Integer userId);

}
