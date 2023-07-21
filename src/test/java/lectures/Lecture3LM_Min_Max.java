package lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class Lecture3LM_Min_Max {

    @Test
    public void min() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
        Integer min = numbers.stream()
//                .min((number1, number2) -> number1 > number2 ? 1 : -1)
                .min(Comparator.naturalOrder())
                .get();
        assertThat(min).isEqualTo(1);
        System.out.println(min);
    }

    @Test
    public void max() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
        assertThat(max).isEqualTo(100);
        System.out.println(max);
    }
}
