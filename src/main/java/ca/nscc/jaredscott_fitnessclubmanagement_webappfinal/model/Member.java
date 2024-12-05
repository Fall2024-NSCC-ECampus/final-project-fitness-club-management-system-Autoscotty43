package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Member name is required
    private String name;

    @Column(nullable = false, unique = true) // Email is unique and required
    private String email;

    private String schedule; // Schedule information

    // Getter and setter for 'membershipType'
    @Setter
    @Getter
    @Column(nullable = false)
    private String membershipType;
}