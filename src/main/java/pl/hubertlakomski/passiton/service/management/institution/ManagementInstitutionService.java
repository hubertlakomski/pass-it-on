package pl.hubertlakomski.passiton.service.management.institution;

import java.util.List;

public interface ManagementInstitutionService {

    InstitutionDTO get(Long id);
    InstitutionDTO save(InstitutionDTO institution);
    InstitutionDTO update(InstitutionDTO institution);
    void delete(Long id);
    List<InstitutionDTO> findAll();

}
