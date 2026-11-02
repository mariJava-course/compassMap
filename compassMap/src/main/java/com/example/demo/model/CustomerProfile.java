package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private  CodeProfile codeProfile;
    private String name;
    private String description;
    private String goal;
    // answers of the customer per dimension
    // @ElementCollection is used to map a collection of basic types
    // we use Map<Dimension, Boolean> to store the answers of the customer per dimension
    // Hibernate can inject PersistentMap on load;
    // Jackson still deserializes the JSON object fine on request.
    // HashMap does not work with H2 because of the size limit of the column
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Dimension, Boolean> answers;

    // recommended roadmap
    //private RoadMap recommendedRoadmap;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "CUST_PROF_ROADMAP_JOIN_TABLE",
            joinColumns = { @JoinColumn(name = "CUST_PROF_FK") },
            inverseJoinColumns = { @JoinColumn(name = "ROAD_MAP_FK")})
    private List<RoadMap> roadMaps = new ArrayList<>();


    public String toString() {
        return String.format(
                "Profile[id=%s, codeprofile='%s', name='%s', description='%s', goal='%s', answers='%s', roadmaps='%s']",
                id, codeProfile, name, description, goal, answers, roadMaps);
    }
}
