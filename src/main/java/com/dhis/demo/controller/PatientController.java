package com.dhis.demo.controller;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import com.dhis.demo.model.Patient;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {
    private ResourceLoader resourceLoader;


    @GetMapping
    public List<Patient> get() throws IOException {

        return List.of(
                new Patient(1L, "Kathy Reyes", 80.88, 1.75),
                new Patient(2L, "Fulton Ortiz", 66.23, 1.55),
                new Patient(3L, "Esmeralda Walker", 57.84, 1.69),
                new Patient(4L, "Marsh Hahn", 78.17, 1.90),
                new Patient(5L, "Louella Fleming", 84.93, 1.48),
                new Patient(6L, "Anthony Pate", 56.29, 1.64)
        );
    }
}
