package com.disney.studios.model;

import com.disney.studios.model.Breed;

import javax.persistence.*;
/**
 * Bootstraps the Spring Boot com.disney.studios.model.Dog
 *
 * Created by Saikumar on 1/30/2024
 */
@Entity
public class Dog {
    /**
     id- unique, generated value,
     Breed-one dog should belong to one breed and multiple dogs can belong to one breed,
     imageUrl, favorites
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breed_id")
    private Breed breed;
    private String imageUrl;
    private int favorites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }
    // Constructors, getters, setters, etc.
}

