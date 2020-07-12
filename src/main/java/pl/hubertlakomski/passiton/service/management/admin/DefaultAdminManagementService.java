package pl.hubertlakomski.passiton.service.management.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.security.User;
import pl.hubertlakomski.passiton.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultAdminManagementService implements ManagementAdminService{

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Set<AdminDTO> findAll() {

        List<User> admins = new ArrayList<>();

        //TODO how to get from db user with roles contains ROLE_ADMIN
        for(User user: userRepository.findAllWithRoles()){

            if(user.getRoles().contains("ROLE_ADMIN")){

                admins.add(user);

            }

        }

        return admins
                .stream().map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    @Override
    public AdminDTO get(Long id) {

        User persisted = userRepository.getOne(id);

        if(isAdmin(persisted)){

            return convertToDto(persisted);
        }
        else{

            throw new IllegalArgumentException("User doesn't have admin role");
        }
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {

        if(isAdmin(convertToEntity(adminDTO))){

            User entity = userRepository.save(convertToEntity(adminDTO));

            return convertToDto(entity);
        }
        else{
            throw new IllegalArgumentException("User doesn't have admin role");
        }
    }

    @Override
    public AdminDTO update(AdminDTO adminDTO) {

        if(isAdmin(convertToEntity(adminDTO))){

            User persisted = userRepository.getOne(adminDTO.getId());

            modelMapper.map(adminDTO, persisted);

            userRepository.save(persisted);

            return convertToDto(persisted);
        }
        else{
            throw new IllegalArgumentException("User doesn't have admin role");
        }

    }

    @Override
    public void delete(Long id) {

        User persisted = userRepository.getOne(id);

        if(isAdmin(persisted)){

            userRepository.delete(persisted);
        }

        else{
            throw new IllegalArgumentException("User doesn't have admin role");
        }

    }

    private boolean isAdmin(User user){

        return user.getRoles().contains("ROLE_ADMIN");
    }

    private AdminDTO convertToDto(User user){

        return modelMapper.map(user, AdminDTO.class);
    }

    private User convertToEntity(AdminDTO adminDTO){

        return modelMapper.map(adminDTO, User.class);
    }
}
