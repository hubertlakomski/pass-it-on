package pl.hubertlakomski.passiton.service.donation.add;

import java.util.List;

public interface DonationAddService {

    List<CategoryListDonationAddData> getListOfCategories();
    List<InstitutionListDonationAddData> getListOfInstitutions();

}
