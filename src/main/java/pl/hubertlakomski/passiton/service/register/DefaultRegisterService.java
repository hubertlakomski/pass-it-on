package pl.hubertlakomski.passiton.service.register;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.security.Roles;
import pl.hubertlakomski.passiton.domain.models.security.User;
import pl.hubertlakomski.passiton.domain.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class DefaultRegisterService implements RegisterService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void process(RegisterData registerData) {

        if(!registerData.getPassword().equals(registerData.getPassword2())){

            throw new IllegalStateException("Passwords do not match");
        }

        User user = new User();

        user.setActive(true);
        user.setEmail(registerData.getEmail());
        user.setPassword(passwordEncoder.encode(registerData.getPassword()));
        user.getRoles().add(Roles.ROLE_USER.name());

        userRepository.save(user);
    }
}
