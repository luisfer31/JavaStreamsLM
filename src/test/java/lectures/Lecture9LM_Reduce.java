package lectures;


import org.junit.Test;

import java.util.Arrays;

public class Lecture9LM_Reduce {

    @Test
    public void reduce() throws Exception {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers).reduce(0, (integer, integer2) -> integer + integer2);

        System.out.println(sum);

        // second way todo

        int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);

        System.out.println(sum2);

        // average of number list

        double average = Arrays.stream(integers).mapToDouble(Integer::doubleValue).average().orElse(0);
        System.out.printf("%.2f",average);

    }


}

