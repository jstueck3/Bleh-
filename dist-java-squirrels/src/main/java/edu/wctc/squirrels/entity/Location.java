package edu.wctc.squirrels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="Location")
public class Location {
    @Id
    @Column(name="location_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="country")
    private String country;
}
