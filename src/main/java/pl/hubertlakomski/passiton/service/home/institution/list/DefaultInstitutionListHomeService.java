package pl.hubertlakomski.passiton.service.home.institution.list;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Institution;
import pl.hubertlakomski.passiton.domain.repositories.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultInstitutionListHomeService implements InstitutionListHomeService {

    private final InstitutionRepository institutionRepository;

    @Override
    public List<InstitutionListHomeData> getList() {

        List<InstitutionListHomeData> dataList = new ArrayList<>();

        for(Institution institution: institutionRepository.findAll()){

            InstitutionListHomeData data = new InstitutionListHomeData();

            data.setName(institution.getName());
            data.setDescription(institution.getDescription());

            dataList.add(data);
        }

        return dataList;
    }
}
