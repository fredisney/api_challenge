import com.disney.studios.model.Dog;
import com.disney.studios.model.DogLike;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class DogLikeTest {


    @Test
    public void testGettersAndSetters() {
        // Given
        Dog dog = new Dog();
        dog.setId(1L);

        DogLike dogLike = new DogLike();
        dogLike.setId(1L);
        dogLike.setDog(dog);
        dogLike.setIpAddress("127.0.0.1");
        dogLike.setVote(1);
        dogLike.setCreatedAt(Instant.parse("2022-01-01T12:00:00Z"));
        dogLike.setUpdatedAt(Instant.parse("2022-01-02T12:00:00Z"));


        // When
        Long dogLikeId = dogLike.getId();
        String dogLikeIpAddress = dogLike.getIpAddress();
        Integer dogLikeVote = dogLike.getVote();
        Instant dogLikeCreatedAt = dogLike.getCreatedAt();
        Instant dogLikeUpdatedAt = dogLike.getUpdatedAt();

        // Then
        assertThat(dogLikeId).isEqualTo(1L);
        assertThat(dogLike).isEqualTo(dog);
        assertThat(dogLikeIpAddress).isEqualTo("127.0.0.1");
        assertThat(dogLikeVote).isEqualTo(1);
        assertThat(dogLikeCreatedAt).isEqualTo(Instant.parse("2022-01-01T12:00:00Z"));
        assertThat(dogLikeUpdatedAt).isEqualTo(Instant.parse("2022-01-02T12:00:00Z"));
    }
}
