package ca.nscc.jaredscott_fitnessclubmanagement_webappfinal.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Data
@Entity
@Table(name = "admins") // Table name in the database
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key
    private Long id;

    @Column(unique = true, nullable = false) // Unique and required username
    private String username;

    @Column(nullable = false) // Password is required
    private String password;

    // Hash and set the password
    public void setPassword(String rawPassword) {
        this.password = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
}