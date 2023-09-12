package com.example.hotelapp.car;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

/**********************************
Restfull type controller Autowired Service and called methods
***********************************/
@Controller
@RequestMapping("/cars")
public class CarController {

    //initialise logger class to print log information to console
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarService carService;

    //direct empty path to /
    @GetMapping
    public String redirectCarList(@RequestParam(required = false) String message, Model model) {
        logger.info("Redirect to cars");
        return "redirect:/cars/";
    }

    /**********************************
    @RequestParam(required = false)  String message optional request parameter;
    ***********************************/
    @GetMapping("/")
    public String showCarList(@RequestParam(required = false) String message, Model model) {

        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);

        if (message != null) {
            model.addAttribute("message", null);
        }

        logger.info("List all cars");
        return "cars/index";

    }

    /**********************************
    @PathVariable Long id segment gets car by id;
    ***********************************/
    @GetMapping("/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model, final RedirectAttributes redirectAttrs) {

        try{

            Car car = carService.getCar(id); 
            model.addAttribute("car", car);
            logger.info("Get car by id "+id.toString());
            return "cars/update";

        } catch (Exception e){

            //add error message if ID not recognised
            redirectAttrs.addFlashAttribute("message", "Car id is not valid");
            List<Car> cars = carService.getCars();
            model.addAttribute("cars", cars);

            logger.error("Car id is not valid");
            return "redirect:/cars/";
        }
    }

    /**********************************
    Show add page
    ***********************************/
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("car", new Car(null, null));

        logger.info("Show add car page");
        return "cars/add";
    }

    /**********************************
    @PathVariable Long id segment updates car by id;
    ***********************************/
    @PutMapping("/{id}")
    public String updateCar(@PathVariable Long id, @Valid Car car, BindingResult result, Model model) {

            if (result.hasErrors()) {
                car.setId(id);
                logger.error("The was an error updating the car");
                return "cars/update";
            }
            
            String carResult = carService.updateCar(id, car);
            logger.info(carResult);
            return "redirect:/cars/";
    }

    /**********************************
    @Valid Car car validation of car using the car entity
    ***********************************/
    @PostMapping("")
    public String addCar(@Valid Car car, BindingResult result, Model model) {

        if (result.hasErrors()) {
            logger.error("Error adding car");
            return "redirect:/cars/add";
        }

        String carResult = carService.createCar(car);
        logger.info(carResult);
        return "redirect:/cars/";
    }

    /**********************************
    @PathVariable Long id segment deletes car by id;
    ***********************************/
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id, Model model, final RedirectAttributes redirectAttrs) {

        try{

            String carResult = carService.deleteCar(id);
            logger.info(carResult);
            return "redirect:/cars/";

        } catch(Exception e){
            //add error message if ID not recognised
            redirectAttrs.addFlashAttribute("message", "Cannot delete: Car id is not valid");
            List<Car> cars = carService.getCars();
            model.addAttribute("cars", cars);
            logger.error("Error deleting car "+id.toString());
            return "redirect:/cars/";
        }
        
    }
}
