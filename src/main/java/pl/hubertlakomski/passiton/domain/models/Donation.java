package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="donations") @Getter @Setter
public class Donation extends ParentEntity{

    private Integer quantity; //number of bags

    @ManyToMany
    @JoinTable(name="donation_categories")
    private List<Category> categoryList
            = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="institution_id")
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;

    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

    private String pickUpComment;

}
