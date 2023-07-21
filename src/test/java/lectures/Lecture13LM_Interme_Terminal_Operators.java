package lectures;

import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture13LM_Interme_Terminal_Operators {
  @Test
  public void intermediateAndTerminalOperations() throws Exception {
//      List<Car> collect = MockData.getCars()
//              .stream()
//              .filter(car -> car.getPrice() < 6000)
//              .collect(Collectors.toList());
//      long count = collect.stream().count();
//      System.out.printf("Numbers of cars = %d", count);

      System.out.println(
              MockData.getCars()
                      .stream()
                      .filter(car -> {
                          System.out.println("filter car "+car);
                          return car.getPrice() < 10000;
                      })
                      .map(car -> {
                          System.out.println("mapping car " + car);
                          return car.getPrice();
                      })
                      .map(price->{
                          System.out.println("mapping price " + price);
                          return price + (price*0.14);
                      })
                      .collect(Collectors.toList())
      );

  }
}
