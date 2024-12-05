package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}