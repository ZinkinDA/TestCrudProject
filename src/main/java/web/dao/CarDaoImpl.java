package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao{

    private static final List<Car> listCar = new ArrayList<>();

    static {
        listCar.add(new Car("BMW","Alexey","M056EX"));
        listCar.add(new Car("AUDI","Dmitry","X152AX"));
        listCar.add(new Car("SUZUKI","Olga","K554AT"));
        listCar.add(new Car("Lada","Vlad","L006OX"));
        listCar.add(new Car("Volkswagen","Vladimir","T444TT"));

    }

    @Override
    public List<Car> getCars(int counter) {
        if (counter == 0) {
            return listCar;
        }

        return listCar.stream().limit(counter).collect(Collectors.toList());
    }

}
