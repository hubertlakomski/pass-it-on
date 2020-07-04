package pl.hubertlakomski.passiton.service.donation;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationData {

    private List<Long> categoriesIds;
    private Long institutionId;
    private String zipCode;
    private String street;
    private String city;
    private Integer quantity;
    private String pickUpComment;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

}
