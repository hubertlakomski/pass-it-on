package pl.hubertlakomski.passiton.service.donation.add;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Category;
import pl.hubertlakomski.passiton.domain.models.Institution;
import pl.hubertlakomski.passiton.domain.repositories.CategoryRepository;
import pl.hubertlakomski.passiton.domain.repositories.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDonationAddService implements DonationAddService{

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    @Override
    public List<CategoryListDonationAddData> getListOfCategories() {

        List<CategoryListDonationAddData> dataList = new ArrayList<>();

        for(Category category: categoryRepository.findAll()){

            CategoryListDonationAddData data = new CategoryListDonationAddData();

            data.setName(category.getName());
            data.setId(category.getId());

            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public List<InstitutionListDonationAddData> getListOfInstitutions() {

        List<InstitutionListDonationAddData> dataList = new ArrayList<>();

        for(Institution institution: institutionRepository.findAll()){

            InstitutionListDonationAddData data = new InstitutionListDonationAddData();

            data.setId(institution.getId());
            data.setName(institution.getName());
            data.setDescription(institution.getDescription());

            dataList.add(data);
        }

        return dataList;
    }
}
