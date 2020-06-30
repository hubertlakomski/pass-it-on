package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories") @Getter @Setter
public class Category extends ParentEntity {

    private String name;

}
