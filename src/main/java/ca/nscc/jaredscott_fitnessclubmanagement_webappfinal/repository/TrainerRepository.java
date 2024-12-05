package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}