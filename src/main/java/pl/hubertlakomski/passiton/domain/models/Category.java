package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categories") @Getter @Setter
public class Category extends ParentEntity {

    @NotBlank
    @Column(nullable = false)
    private String name;

}
