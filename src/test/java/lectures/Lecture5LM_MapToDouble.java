package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture5LM_MapToDouble {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    List<Car> carsFilter = cars.stream()
            .filter(carPredicate)
            .collect(Collectors.toList());

    carsFilter.forEach(System.out::println);
    System.out.println(carsFilter.size());
  }



  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    ImmutableList<Person> people = MockData.getPeople();

//    List<PersonDTO> dtos = people.stream().map(person -> {
//              PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//              return dto;
//            })
//            .collect(Collectors.toList());

//    List<PersonDTO> dtos = people.stream()
//            .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
//            .collect(Collectors.toList());

    List<PersonDTO> dtos = people.stream().map(PersonDTO::map).collect(Collectors.toList());

//    Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(),
//            person.getFirstName(), person.getAge());
//
//    List<PersonDTO> dtos = people.stream().map(personPersonDTOFunction)
//              .collect(Collectors.toList());

      dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
            .stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



