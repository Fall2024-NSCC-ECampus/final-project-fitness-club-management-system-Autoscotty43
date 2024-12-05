package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id).orElse(null);
        if (trainer == null) {
            throw new RuntimeException("Trainer not found with id: " + id);
        }
        return trainer;
    }

    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}