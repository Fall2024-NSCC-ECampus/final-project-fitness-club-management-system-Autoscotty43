package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findByUsernameAndPassword(String username, String password);
}