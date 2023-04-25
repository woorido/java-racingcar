package racing.domain;

import racing.RandomNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars{

    private final List<Car> cars;
    RandomNumber randomNumber = new RandomNumberGenerator();

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> racingCars(){
        for (Car car : cars) {
           car.move(randomNumber);
            System.out.println(car.toString());
        }
        return cars;
    }

    public static List<Car> getCars(String[] carsName) {
        List<Car> carList = new ArrayList<>();
        Arrays.stream(carsName).forEach(carName-> carList.add(new Car(carName)));
        return carList;
    }

    public List<Car> findWinners() {
        return getCars(getMaxPosition());
    }

    private List<Car> getCars(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
