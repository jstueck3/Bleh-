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
@Table(name="Squirrel")
public class Squirrel {
    @Id
    @Column(name="squirrel_id")
    private int id;
    @Column(name="species")
    private String species;
    @Column(name="common_name")
    private String commonName;
    @Column(name="habitat")
    private String habitat;
    @Column(name="image_file_name")
    private String imageFileName;
    @Column(name = "rating")
    private int rating;
    @Column(name = "behavior")
    private String behavior;

}
