package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="donations") @Getter @Setter
public class Donation extends ParentEntity{

    @Size(min=1, max=10)
    private Integer quantity; //number of bags

    @ManyToMany
    @JoinTable(name="donation_categories")
    private List<Category> categoryList
            = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="institution_id")
    @Column(nullable = false)
    private Institution institution;

    @NotBlank
    @Column(nullable = false)
    private String street;
    @NotBlank
    @Column(nullable = false)
    private String city;
    @NotBlank
    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalTime pickUpTime;

    private String pickUpComment;

}
