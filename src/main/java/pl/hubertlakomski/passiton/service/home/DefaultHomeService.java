package pl.hubertlakomski.passiton.service.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Donation;
import pl.hubertlakomski.passiton.domain.models.Institution;
import pl.hubertlakomski.passiton.domain.repositories.DonationRepository;
import pl.hubertlakomski.passiton.domain.repositories.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultHomeService implements HomeService {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @Override
    public List<InstitutionListHomeData> getListOfInstitutions() {

        List<InstitutionListHomeData> dataList = new ArrayList<>();

        for(Institution institution: institutionRepository.findAll()){

            InstitutionListHomeData data = new InstitutionListHomeData();

            data.setName(institution.getName());
            data.setDescription(institution.getDescription());

            dataList.add(data);
        }

        return dataList;
    }

    @Override
    public Integer getNumberOfReturnedBags() {

        Integer numberOfReturnedBags = 0;

        for(Donation donation: donationRepository.findAll()){

            numberOfReturnedBags+=donation.getQuantity();
        }

        return numberOfReturnedBags;
    }

    @Override
    public Integer getNumberOfDonations() {

        Integer numberOfDonations = 0;

        for(Donation ignored: donationRepository.findAll()){

            numberOfDonations++;

        }

        return numberOfDonations;
    }
}
