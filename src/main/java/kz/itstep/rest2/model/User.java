package kz.itstep.rest2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username",
            unique = true, length = 15,
            columnDefinition = "varchar(15) default 'nurgissa'")
    @NotNull(message = "Username should not be null")
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 6, max = 15)
    private String username;

    @Column(name = "password", length = 20)
    @NotEmpty(message = "Password should not be empty")
    @NotNull(message = "Password should not be null")
    @Size(min = 8, max = 20)
//    @Pattern(
//            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$",
//            message = "Password has not correct format")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
