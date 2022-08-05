package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;
import web.service.ServiceImpl;
import web.service.ServiceInterface;

@Controller
public class CarController {
    private ServiceImpl service;

    @Autowired
    public CarController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/cars")
    public String getAllCars(@RequestParam(value = "count",required = false)  Integer count, Model model){
        //если коунт !=0, то метод ДАО с коунтом и один хтмл, иначе другой метод ДАО и другой хтмл
        System.out.println(count);
        if (count!= null) {
            model.addAttribute("cars", service.getCars(count));
            return "cars";
        } else {
            model.addAttribute("cars",service.getCars());
            return "cars";
        }
    }
}
