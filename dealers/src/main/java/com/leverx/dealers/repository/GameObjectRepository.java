package com.leverx.dealers.repository;

import com.leverx.dealers.entity.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameObjectRepository extends JpaRepository<GameObject,Integer> {
}
