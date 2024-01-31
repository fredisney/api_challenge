import com.disney.studios.model.Breed;
import com.disney.studios.model.Dog;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreedTest {

    @Test
    public void testGettersAndSetters() {
        // Given
        Breed breed = new Breed();
        breed.setId(1L);
        breed.setName("Labrador");

        Dog dog1 = new Dog();
        dog1.setId(1L);
        dog1.setBreed(breed);
        dog1.setFavorites(10);
        dog1.setImageUrl("labrador1.jpg");

        Dog dog2 = new Dog();
        dog2.setId(2L);
        dog2.setBreed(breed);
        dog2.setFavorites(15);
        dog2.setImageUrl("labrador2.jpg");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);

        breed.setDogs(dogs);

        // When
        Long breedId = breed.getId();
        String breedName = breed.getName();
        List<Dog> breedDogs = breed.getDogs();

        // Then
        assertThat(breedId).isEqualTo(1L);
        assertThat(breedName).isEqualTo("Labrador");
        assertThat(breedDogs).hasSize(2);
        assertThat(breedDogs.get(0).getFavorites()).isEqualTo(10);
        assertThat(breedDogs.get(1).getFavorites()).isEqualTo(15);
    }
}
