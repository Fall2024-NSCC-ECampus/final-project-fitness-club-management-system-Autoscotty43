package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Data
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Trainer name is required
    private String name;

    private String shift; // Work shift for the trainer

    @Column(unique = true, nullable = false) // Unique and required email
    private String email;

    // Getter and setter for 'specialty'
    @Setter
    @Getter
    @Column(nullable = false)
    private String specialty;
    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String username;

    // Hash and set the password
    public void setPassword(String rawPassword) {
        this.password = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
}