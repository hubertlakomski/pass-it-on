package pl.hubertlakomski.passiton.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="institutions") @Getter @Setter
public class Institution extends ParentEntity{

    private String name;
    private String description;

}
