package com.example.demoannotationsincontrollermethod.controller;

import com.example.demoannotationsincontrollermethod.ds.Country;
import com.example.demoannotationsincontrollermethod.ds.Person;
import com.example.demoannotationsincontrollermethod.storage.InMemoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestPartController {

    @Autowired
    private InMemoryStorage inMemoryStorage;

    @PostMapping("/example1")
    @ResponseBody
    public String example1(@RequestPart("person") Person person, @RequestPart("country") Country country) {
        return String.format(
                "Received Person = [%s}, country = [%s]", person, country
        );
    }

    // file upload

    @GetMapping("/example2/gallery")
    public String example2(Model model) {
        model.addAttribute("imageNames", inMemoryStorage.getNames());
        return "gallery";
    }

    @GetMapping(value = "/example2/gallery/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] example3(@PathVariable String imageName) {
        return inMemoryStorage.getByName(imageName);
    }

    // store image in storage
    @PostMapping("/example2/gallery")
    public String exampleUpload(@RequestPart("file")MultipartFile file) throws IOException {
        inMemoryStorage.store(file.getOriginalFilename(), file.getBytes());
        return "redirect:/example2/gallery";
    }
}

// curl -F 'person={"firstname": "John","lastName":"Doe"};type=application/json' -F 'country={"country":"US"};type=application/json' http://localhost:8080/example1