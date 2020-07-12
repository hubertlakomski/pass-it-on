package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import pl.hubertlakomski.passiton.domain.models.security.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="donations") @Getter @Setter
public class Donation extends ParentEntity{

    @Min(1)
    private Integer quantity; //number of bags

    private boolean isPickedUp = false;
    private LocalDateTime realPickUpTime; //time of real pickUpTime

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User donatingUser;

    @ManyToMany
    @JoinTable(name="donation_categories")
    private List<Category> categoryList
            = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="institution_id")
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

    @Column(nullable = false, name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(nullable = false, name = "pick_up_time")
    private LocalTime pickUpTime;

    @Column(name = "pick_up_comment")
    private String pickUpComment;

}
