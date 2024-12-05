package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.controller;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // Display the list of trainers
    @GetMapping
    public String listTrainers() {
        return "trainers/list"; // View template for displaying trainers
    }

    // Add a new trainer
    @PostMapping("/add")
    public String addTrainer(@ModelAttribute Trainer trainer) {
        trainerService.addTrainer(trainer);
        return "redirect:/trainers"; // Redirect to trainer list after adding
    }

    // Delete a trainer by ID
    @PostMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "redirect:/trainers"; // Redirect to trainer list after deletion
    }
}