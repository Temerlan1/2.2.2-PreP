package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.InitBinder;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    private static int CAR_COUNT;
    private List<Car> list;


    public void init(){
        list = new ArrayList<>();
        list.add(new Car(++CAR_COUNT, "BMV", "black"));
        list.add(new Car(++CAR_COUNT, "Lada", "white"));
        list.add(new Car(++CAR_COUNT, "Toyota", "red"));
        list.add(new Car(++CAR_COUNT, "Lexus", "green"));
        list.add(new Car(++CAR_COUNT, "Bugatti", "blue"));
    }

    @Override
    public List<Car> getCars() {
        return list;
    }//ВОЗВРАЩАТЬ СПИСОК ВСЕХ МАШИН

    @Override
    public List<Car> getCars(int count) {
        if (count < 5) {
            return list.stream().limit(count).collect(Collectors.toList());
        }
        return list;
    }//ВОЗВРАЩАТЬ СПИСОК ОПР. КОЛИЧЕСТВА МАШИН
}
