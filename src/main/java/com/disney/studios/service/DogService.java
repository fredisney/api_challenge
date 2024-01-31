package com.disney.studios.service;

import com.disney.studios.controller.error.ResourceNotFoundException;
import com.disney.studios.model.Dog;
import com.disney.studios.model.DogLike;
import com.disney.studios.model.vm.VoteVm;
import com.disney.studios.repository.DogLikeRepository;
import com.disney.studios.repository.DogRepository;
import com.disney.studios.service.dto.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    DogLikeRepository dogLikeRepository;

    public List<Dog> getAllDogsSortedByFavorites() {
        return dogRepository.findByOrderByFavoritesDesc();
    }

    public List<DogDto> getDogsByBreed(String breed) {
        return DogDto.toList(dogRepository.findByBreedName(breed));
    }

    public Dog getDogById(Long id) {
        return dogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public String updateFavorites(Long id, String ipAddress, Integer newFavorites) {
        Dog dog = getDogById(id);
        if (dog != null) {
            DogLike dogLike = dogLikeRepository.findByDogAndIpAddress(dog.getId(), ipAddress).orElse(new DogLike());
            if (dogLike.getVote() != null && dogLike.getVote() == VoteVm.VOTE_UP && newFavorites == VoteVm.VOTE_UP) {
                return "you already liked this dog";
            } else if (dogLike.getVote() != null && dogLike.getVote() == VoteVm.VOTE_DOWN && newFavorites == VoteVm.VOTE_DOWN) {
                return "you already disliked this dog";
            } else {
                if (newFavorites == VoteVm.VOTE_UP || newFavorites == VoteVm.VOTE_DOWN) {
                    dogLike.setDog(dog);
                    dogLike.setVote(newFavorites);
                    dogLike.setIpAddress(ipAddress);
                    dogLikeRepository.save(dogLike);
                    int count = newFavorites == VoteVm.VOTE_UP ? 1 : -1;
                    dog.setFavorites(dog.getFavorites() + count);
                    dogRepository.save(dog);
                    return "successfully " + (newFavorites == VoteVm.VOTE_UP ? " liked " : "disliked");
                } else {
                    return "please provide 1 for like and 0 for dislike";
                }
            }
        }
        return "dog not found";
    }
}