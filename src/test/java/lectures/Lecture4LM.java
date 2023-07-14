package lectures;


import com.google.common.collect.ImmutableList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lecture4LM {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

    assertThat(distinctNumbers).hasSize(9);

    System.out.println(distinctNumbers);

  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 1, 1, 2, 2, 3, 3, 10, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    Set<Integer> distinctNumbers = numbers.stream().collect(Collectors.toSet());

    assertThat(distinctNumbers).hasSize(10);

    System.out.println(distinctNumbers);

  }
}
