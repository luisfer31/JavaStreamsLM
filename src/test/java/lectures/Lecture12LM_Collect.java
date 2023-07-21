package lectures;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture12LM_Collect {
    @Test
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)

                .collect(Collectors.toList());

                // collect lambda
//                .collect(() -> new ArrayList<String>(),
//                        (list, element) -> list.add(element),
//                        (list1, list2) -> list1.addAll(list2));
//                .collect(Collectors.toList());

                //collect method reference
//                .collect(ArrayList::new,
//                        ArrayList::add,
//                        ArrayList::addAll);

        System.out.println("Number of emails: " + emails.stream().count());
        emails.forEach(System.out::println);

    }
}
