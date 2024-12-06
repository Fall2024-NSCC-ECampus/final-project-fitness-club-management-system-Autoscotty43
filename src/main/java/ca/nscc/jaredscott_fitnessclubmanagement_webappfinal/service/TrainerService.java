package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.service;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer login(String username, String password) {
        return trainerRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public Trainer addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return trainer;
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    public Trainer getTrainerById(Long trainerId) {
        return null;
    }
}