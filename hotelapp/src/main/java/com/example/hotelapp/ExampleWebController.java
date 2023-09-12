package com.example.hotelapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hotelapp.car.CarService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/example")
public class ExampleWebController {

    @Autowired
    CarService exampleService;


    @GetMapping("")
    public String showAll(@RequestParam(required = false) String message, Model model) {
        
        //Add code
        //List<Example> examples = exampleService.GetExamples();
        //model.addAttribute("examples", examples);

        return "example/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        //model.addAttribute("example", new Example(null));

        return "example/add";
    }

    @PostMapping("")
    public String create(@Valid String example, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "redirect:/example/add";
        }

        //String addResult = exampleService.CreateExample(example);
        //model.addAttribute("message", addResult);
        return "redirect:/example";
    }
    
}
