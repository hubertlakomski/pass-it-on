package pl.hubertlakomski.passiton.service.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Category;
import pl.hubertlakomski.passiton.domain.models.Donation;
import pl.hubertlakomski.passiton.domain.models.Institution;
import pl.hubertlakomski.passiton.domain.models.security.User;
import pl.hubertlakomski.passiton.domain.repositories.CategoryRepository;
import pl.hubertlakomski.passiton.domain.repositories.DonationRepository;
import pl.hubertlakomski.passiton.domain.repositories.InstitutionRepository;
import pl.hubertlakomski.passiton.domain.repositories.UserRepository;
import pl.hubertlakomski.passiton.service.data.CategoryListData;
import pl.hubertlakomski.passiton.service.data.InstitutionListData;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDonationService implements DonationService {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    @Override
    public void saveDonation(DonationData data) {

        Donation donation = new Donation();

        donation.getCategoryList().addAll(categoryRepository.findAllById(data.getCategoriesIds()));
        donation.setInstitution(institutionRepository.getOne(data.getInstitutionId()));
        donation.setQuantity(data.getQuantity());
        donation.setCity(data.getCity());
        donation.setStreet(data.getStreet());
        donation.setZipCode(data.getZipCode());
        donation.setPickUpComment(data.getPickUpComment());
        donation.setPickUpDate(data.getPickUpDate());
        donation.setPickUpTime(data.getPickUpTime());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(authentication.getName());

        donation.setDonatingUser(user);

        donationRepository.save(donation);
    }

    @Override
    public List<CategoryListData> getListOfCategories() {

        List<CategoryListData> dataList = new ArrayList<>();

        for(Category category: categoryRepository.findAll()){

            CategoryListData data = new CategoryListData();

            data.setName(category.getName());
            data.setId(category.getId());

            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public List<InstitutionListData> getListOfInstitutions() {

        List<InstitutionListData> dataList = new ArrayList<>();

        for(Institution institution: institutionRepository.findAll()){

            InstitutionListData data = new InstitutionListData();

            data.setId(institution.getId());
            data.setName(institution.getName());
            data.setDescription(institution.getDescription());

            dataList.add(data);
        }

        return dataList;
    }

}
