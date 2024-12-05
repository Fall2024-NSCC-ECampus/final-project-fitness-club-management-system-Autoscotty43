package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.repository;

import ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}