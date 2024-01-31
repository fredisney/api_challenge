package com.disney.studios.service.dto;

import com.disney.studios.model.Dog;

import java.util.List;
import java.util.stream.Collectors;

public class DogDto {
    private Long id;
    private String imageUrl;
    private int favorites;

    public DogDto(Dog dog) {
        this.id = dog.getId();
        this.imageUrl = dog.getImageUrl();
        this.favorites = dog.getFavorites();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static List<DogDto> toList(List<Dog> dogs) {
        return dogs.stream().map(DogDto::new).collect(Collectors.toList());
    }
}
