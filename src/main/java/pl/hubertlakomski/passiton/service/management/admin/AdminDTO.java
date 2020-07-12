package pl.hubertlakomski.passiton.service.management.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class AdminDTO {

    private Long id;
    private boolean active;
    private String email;
    @JsonIgnore
    private String password;

    private Set<String> roles = new HashSet<>();
}
