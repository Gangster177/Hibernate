package ru.homework.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="homework_orm")
public class Persons{

    @EmbeddedId
    private PersonId personId;

    @Column(name = "phone_number", columnDefinition = "varchar(15) default 'X-XXX-XXX-XX-XX'")
    private String phoneNumber;

    @ColumnDefault("'unknown'")
    @Column(name = "city_of_living")
    private String cityOfLiving;
}
