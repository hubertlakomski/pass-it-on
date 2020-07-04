package pl.hubertlakomski.passiton.service.donation;

import pl.hubertlakomski.passiton.service.data.CategoryListData;
import pl.hubertlakomski.passiton.service.data.InstitutionListData;

import java.util.List;

public interface DonationService {

    List<CategoryListData> getListOfCategories();
    List<InstitutionListData> getListOfInstitutions();
    void saveDonation(DonationData data);

}
