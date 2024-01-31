package com.disney.studios.repository;

import com.disney.studios.model.Dog;
import com.disney.studios.model.DogLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DogLikeRepository extends JpaRepository<DogLike, Long> {

    @Query("select d from DogLike d left join d.dog dd where dd.id = ?1 and d.ipAddress = ?2")
    Optional<DogLike> findByDogAndIpAddress(Long dogId, String ipAddress);
}
