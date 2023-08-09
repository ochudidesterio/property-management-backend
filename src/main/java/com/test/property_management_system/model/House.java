package com.test.property_management_system.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String name;
    private double rentAmount;
    private double depositAmount;
    @JsonProperty
    private boolean isVacant=true;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;
    @OneToOne
    @JsonIgnore
    private Tenant tenant;
    @OneToMany(mappedBy = "house")
    @JsonIgnore
    private List<HouseImagesModel>houseImages;

}
