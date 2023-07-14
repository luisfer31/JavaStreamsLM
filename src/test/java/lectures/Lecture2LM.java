package lectures;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class Lecture2LM {
    @Test
    public void range() throws Exception {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        IntStream.range(0, 10).forEach(System.out::println);
        System.out.println();
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

    }

    @Test
    public void rangeIteratingList() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    Person person = people.get(index);
                    System.out.println(person);
                });

    }

    @Test
    public void intStreamIterate() throws Exception {
        IntStream.iterate(0,operand -> operand +1)
                .filter(value -> value % 2 == 0)
                .limit(10)
                .forEach(System.out::println);
    }
}
