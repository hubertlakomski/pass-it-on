package pl.hubertlakomski.passiton.service.management.institution;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Institution;
import pl.hubertlakomski.passiton.domain.repositories.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultManagementInstitutionService implements ManagementInstitutionService {

    private final InstitutionRepository institutionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<InstitutionDTO> findAll() {

        return institutionRepository.findAll()
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstitutionDTO get(Long id) {

        return convertToDto(institutionRepository.getOne(id));
    }

    @Override
    public InstitutionDTO save(InstitutionDTO institutionDTO) {

        Institution entity = institutionRepository.save(convertToEntity(institutionDTO));

        return convertToDto(institutionRepository.getOne(entity.getId()));
    }

    @Override
    public InstitutionDTO update(InstitutionDTO institutionDTO) {

        Institution persisted = institutionRepository.getOne(institutionDTO.getId());

        modelMapper.map(institutionDTO, persisted);

        institutionRepository.save(persisted);

        return convertToDto(institutionRepository.getOne(persisted.getId()));
    }

    @Override
    public void delete(Long id) {

        institutionRepository.delete(institutionRepository.getOne(id));
    }


    private InstitutionDTO convertToDto(Institution institution){

        return modelMapper.map(institution, InstitutionDTO.class);
    }

    private Institution convertToEntity(InstitutionDTO institutionDTO){

        return modelMapper.map(institutionDTO, Institution.class);
    }

}
