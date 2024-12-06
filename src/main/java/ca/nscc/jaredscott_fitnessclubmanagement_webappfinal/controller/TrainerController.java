package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.controller;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // Add a new trainer
    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    // Trainer login
    @PostMapping("/login")
    public Trainer login(@RequestParam String username, @RequestParam String password) {
        return trainerService.login(username, password);
    }

    // Delete a trainer by ID
    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }

}