package lectures;


import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lecture7LM_Average_Statistics {

    @Test
    public void count() throws Exception {
        long countFemale = MockData.getPeople().stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();
        System.out.println(countFemale);
    }

    @Test
    public void min() throws Exception {
        //Minimum price of a car with yellow color
        double minPriceCarYellow = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(car -> car.getPrice())
                .min()
                .getAsDouble(); //.orElse(0)

        System.out.println(minPriceCarYellow);
    }

    @Test
    public void max() throws Exception {
        //Maximum price of a car with yellow color
        double minPriceCarYellow = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(car -> car.getPrice())
                .max()
                .getAsDouble(); //.orElse(0)
        System.out.println(minPriceCarYellow);

    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
//        ImmutableList<Car>cars=ImmutableList.of(); //Test with empty List
        double averagePrice = cars.stream().mapToDouble(car -> car.getPrice())
                .average()
                .orElse(0);

        System.out.println(averagePrice);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .sum();

        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);// format sum

        System.out.println(sum);
        System.out.println(bigDecimalSum);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();

        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .summaryStatistics();

        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

    }

}