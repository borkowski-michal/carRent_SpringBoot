package pl.borkowski.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    @Length(min = 5, message = "Name must have at least 5 characters")
    @NotEmpty(message = "Field cannot be empty")
    private String firstName;

    @Column
    @Length(min = 5, message = "LastName must have at least 5 characters")
    @NotEmpty(message = "Field cannot be empty")
    private String lastName;

    @Column
    @Email(message = "Invalid email")
    @NotEmpty(message = "Field cannot be empty")
    private String email;

    @Column
    @Length(min = 5, message = "Password must have at least 5 characters")
    @NotEmpty(message = "Field cannot be empty")
    private String password;

    @Column
    @Length(min = 9, message = "Phone number should have min. 9 numbers")
    @NotEmpty(message = "Field cannot be empty")
    private String phone;

    @Column
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}

