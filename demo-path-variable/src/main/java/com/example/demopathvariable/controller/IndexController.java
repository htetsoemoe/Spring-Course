package com.example.demopathvariable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    // curl localhost:8080/actionA/cities/Yangon
    @GetMapping("/actionA/cities/{city}")
    public String cityByCode(@PathVariable("city")String city) {
        return String.format("Retrieved city = [%s]", city);
    }

    // curl localhost:8080/actionB/countries/Myanmar/cities/Yangon
    @GetMapping("/actionB/countries/{country}/cities/{city}")
    public String countryAndCityByCode(@PathVariable("country")String country, @PathVariable(value = "city")String city) {
        return String.format("Retrieved name = [%s], city = [%s]", country, city);
    }

}
