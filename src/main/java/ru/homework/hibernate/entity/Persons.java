package ru.homework.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "homework_orm")
public class Persons {

    @EmbeddedId
    private PersonId personId;

    @Column(name = "phone_number", columnDefinition = "varchar(15) default 'X-XXX-XXX-XX-XX'")
    private String phoneNumber;

    @ColumnDefault("'unknown'")
    @Column(name = "city_of_living")
    private String cityOfLiving;
}
