package pl.hubertlakomski.passiton.domain.models.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.hubertlakomski.passiton.domain.models.ParentEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString(exclude = {"password", "roles"}, callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends ParentEntity {

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean active;
    @Column(unique = true, nullable = false) @Email
    private String email;

    @CollectionTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "email", referencedColumnName = "email")
    )
    @ElementCollection
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

}
