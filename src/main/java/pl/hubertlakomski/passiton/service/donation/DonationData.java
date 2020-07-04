package pl.hubertlakomski.passiton.service.donation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

}
