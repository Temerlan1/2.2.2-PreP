package web.service;

import web.model.Car;

import java.util.List;

public interface ServiceInterface {
    List<Car> getCars();
    List<Car> getCars(int count);
}
