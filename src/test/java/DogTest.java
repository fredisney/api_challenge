import com.disney.studios.model.Breed;
import com.disney.studios.model.Dog;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DogTest {

    @Test
    public void testGettersAndSetters() {
        // Given
        Breed breed = new Breed();
        breed.setId(1L);
        breed.setName("Labrador");

        Dog dog = new Dog();
        dog.setId(1L);
        dog.setBreed(breed);
        dog.setImageUrl("labrador.jpg");
        dog.setFavorites(10);

        // When
        Long dogId = dog.getId();
        Breed dogBreed = dog.getBreed();
        String dogImageUrl = dog.getImageUrl();
        int dogFavorites = dog.getFavorites();

        // Then
        assertThat(dogId).isEqualTo(1L);
        assertThat(dogBreed).isEqualTo(breed);
        assertThat(dogImageUrl).isEqualTo("labrador.jpg");
        assertThat(dogFavorites).isEqualTo(10);
    }
}
