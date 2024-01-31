package com.disney.studios.repository;

import com.disney.studios.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Long> {
    /*
    findByBreed by giving the breed name expecting one or more dogs
    */
    List<Dog> findByBreedName(String breed);

    /*
    findByOrderByFavoritesDesc
    */
    @Query("select d from Dog d left join fetch d.breed order by d.favorites desc")
    List<Dog> findByOrderByFavoritesDesc();

    /*
    findById by giving id expecting details of one particular dog
    */
    @Query("select d from Dog d left join fetch d.breed where d.id = ?1")
    Optional<Dog> findById(Long id);
}
