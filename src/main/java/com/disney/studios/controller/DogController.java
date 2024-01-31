package com.disney.studios.controller;

import com.disney.studios.model.vm.VoteVm;
import com.disney.studios.model.Dog;
import com.disney.studios.service.DogService;
import com.disney.studios.service.dto.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/all")
    public List<Dog> getAllDogsSortedByFavorites() {
        return dogService.getAllDogsSortedByFavorites();
    }

    @GetMapping("/byBreed/{breed}")
    public List<DogDto> getDogsByBreed(@PathVariable String breed) {
        return dogService.getDogsByBreed(breed);
    }

    @GetMapping("/{id}")
    public Dog getDogById(@PathVariable Long id) {
        return dogService.getDogById(id);
    }

    @PostMapping("/{id}/vote")
    public String vote(@PathVariable Long id, @RequestBody VoteVm voteVm,
                       HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return dogService.updateFavorites(id, ip, voteVm.getVote());
    }
}
