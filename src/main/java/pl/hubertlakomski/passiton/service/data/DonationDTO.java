package pl.hubertlakomski.passiton.service.data;

import lombok.Data;
import pl.hubertlakomski.passiton.domain.models.Category;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DonationDTO {

    private Integer quantity;
    private List<Category> categoryList
            = new ArrayList<>();
    private Long institutionId;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

}
