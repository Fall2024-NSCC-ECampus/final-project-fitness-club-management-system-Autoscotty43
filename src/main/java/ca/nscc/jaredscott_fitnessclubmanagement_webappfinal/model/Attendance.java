package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Relationship to a trainer
    private Trainer trainer;

    @ManyToOne // Relationship to a member
    private Member member;

    private boolean present; // Attendance status
}