package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}