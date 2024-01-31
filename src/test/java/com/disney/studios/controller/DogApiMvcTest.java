package com.disney.studios.controller;

import com.disney.studios.model.Dog;
import com.disney.studios.model.vm.VoteVm;
import com.disney.studios.repository.DogRepository;
import com.disney.studios.service.DogService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class DogApiMvcTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DogService dogService;
    @MockBean
    private DogRepository dogRepository;

    @BeforeEach
    public void setUp() {

        // Given
        Dog dog = new Dog();
        dog.setId(1L);

        given(this.dogRepository.findById(1L))
                .willReturn(Optional.of(dog));
    }


    @Test
    @Order(1)
    public void test_1_should_like_same_dog_by_first_person() throws Exception {
        VoteVm voteVm = new VoteVm();
        voteVm.setVote(VoteVm.VOTE_UP);
        String jsonData = JsonHelper.toJson(voteVm).orElse("");

        String expected = "successfully liked";

        when(dogService.updateFavorites(1L, "127.0.0.1", VoteVm.VOTE_UP)).thenReturn(expected);


        mockMvc.perform(post("/dogs/1/vote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

        verifyNoMoreInteractions(this.dogRepository);
    }
//
//    @Test
//    @Order(2)
//    public void test_2_should_like_dog_by_other_person() throws Exception {
//        VoteVm voteVm = new VoteVm();
//        voteVm.setVote(VoteVm.VOTE_UP);
//        String jsonData = JsonHelper.toJson(voteVm).orElse("");
//
//        String expected = "successfully liked";
//
//        when(dogService.updateFavorites(1L, "127.0.0.2", VoteVm.VOTE_UP)).thenReturn(expected);
//
//
//        mockMvc.perform(post("/dogs/1/vote")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(jsonData))
//                //Then
//                .andExpect(status().isOk())
//                .andExpect(content().string(expected));
//
//        verifyNoMoreInteractions(this.dogRepository);
//    }

    @Test
    @Order(3)
    public void test_3_should_like_dog_by_first_person() throws Exception {
        VoteVm voteVm = new VoteVm();
        voteVm.setVote(VoteVm.VOTE_UP);
        String jsonData = JsonHelper.toJson(voteVm).orElse("");

        String expected = "successfully liked";

        when(dogService.updateFavorites(1L, "127.0.0.1", VoteVm.VOTE_UP)).thenReturn(expected);


        mockMvc.perform(post("/dogs/1/vote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

        verifyNoMoreInteractions(this.dogRepository);
    }

    @Test
    @Order(4)
    public void test_4_should_not_like_same_dog_by_first_person() throws Exception {
        VoteVm voteVm = new VoteVm();
        voteVm.setVote(VoteVm.VOTE_UP);
        String jsonData = JsonHelper.toJson(voteVm).orElse("");

        String expected = "you already liked this dog";

        when(dogService.updateFavorites(1L, "127.0.0.1", VoteVm.VOTE_UP)).thenReturn(expected);


        mockMvc.perform(post("/dogs/1/vote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().string(expected));

        verifyNoMoreInteractions(this.dogRepository);
    }

    @Test
    @Order(5)
    public void test_5_should_check_total_likes() throws Exception {
        Dog dog = new Dog();
        dog.setFavorites(1);
        String expected = JsonHelper.toJson(dog).orElse("");

        when(dogService.getDogById(1L)).thenReturn(dog);


        mockMvc.perform(get("/dogs/1")
                        .accept(MediaType.APPLICATION_JSON))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

        verifyNoMoreInteractions(this.dogRepository);
    }
}
