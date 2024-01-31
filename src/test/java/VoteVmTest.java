import com.disney.studios.model.vm.VoteVm;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VoteVmTest {

    @Test
    public void testGettersAndSetters() {
        // Given
        VoteVm voteVm = new VoteVm();
        voteVm.setVote(1);

        // When
        Integer vote = voteVm.getVote();

        // Then
        assertThat(vote).isEqualTo(1);
    }
}
