package pl.hubertlakomski.passiton.service.donation.add;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Category;
import pl.hubertlakomski.passiton.domain.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDonationAddService implements DonationAddService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryListDonationAddData> getListOfCategories() {

        List<CategoryListDonationAddData> dataList = new ArrayList<>();

        for(Category category: categoryRepository.findAll()){

            CategoryListDonationAddData data = new CategoryListDonationAddData();

            data.setName(category.getName());

            dataList.add(data);
        }

        return dataList;
    }
}
