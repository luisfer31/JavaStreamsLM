package lectures;


import beans.Car;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture8LM_GroupinBy {

  @Test
  public void simpleGrouping() throws Exception {
//    Map<Integer, List<Person>> groupingByAge = MockData.getPeople().stream().collect(Collectors.groupingBy(Person::getAge));
//    groupingByAge.forEach((age, person)->{
//      long count = person.stream().count();
//      System.out.println("AGE: "+age + " Number of person : "+count);
//      person.forEach(System.out::println);
//    });

    Map<String, List<Car>> groupingByMake = MockData.getCars()
            .stream()
            .collect(Collectors.groupingBy(Car::getMake));

    groupingByMake.forEach((make,car)->{
      System.out.println(make);
      car.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    Map<String, Long> countingNames = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    countingNames.forEach((name,count)-> System.out.println(name + " > " + count));
  }
}