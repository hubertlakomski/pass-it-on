package pl.hubertlakomski.passiton.service.management.admin;

import java.util.Set;

public interface ManagementAdminService {

    Set<AdminDTO> findAll();
    AdminDTO get(Long id);
    AdminDTO save(AdminDTO adminDTO);
    AdminDTO update(AdminDTO adminDTO);
    void delete(Long id);

}
