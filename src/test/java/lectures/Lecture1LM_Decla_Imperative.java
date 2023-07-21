package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture1LM_Decla_Imperative {
    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> youngPeople = new ArrayList<>();
        final int limit = 10;
        int counter = 0;

        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if (counter == limit){
                    break;
                }
            }
        }

        for (Person young : youngPeople) {
            System.out.println(young);
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws IOException {
//        MockData.getPeople().stream().filter(person -> person.getAge()<=18)
//                .limit(5).collect(Collectors.toList()).forEach(System.out::println);

        ImmutableList<Person> people = MockData.getPeople();

        List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= 18)
                .limit(5).collect(Collectors.toList());
        youngPeople.forEach(System.out::println);
    }
}
