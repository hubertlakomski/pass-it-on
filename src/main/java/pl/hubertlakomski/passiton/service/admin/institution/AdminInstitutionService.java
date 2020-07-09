package pl.hubertlakomski.passiton.service.admin.institution;

import java.util.List;

public interface AdminInstitutionService {

    InstitutionDTO get(Long id);
    InstitutionDTO save(InstitutionDTO institution);
    InstitutionDTO update(InstitutionDTO institution);
    void delete(Long id);
    List<InstitutionDTO> findAll();

}
