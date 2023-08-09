package com.test.property_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tbl_property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String propertyName;
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "property")
    private List<House>houses;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "property")
    private List<PropertyImagesModel>propertyImages;
}
