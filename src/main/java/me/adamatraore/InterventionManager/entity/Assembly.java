package me.adamatraore.InterventionManager.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Assembly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "longi")
    private Float longi;

    //une assemblée peut avoir un ou plusieurs orateurs
    @OneToMany(mappedBy = "assembly")
    private Set<Speaker> speakers = new LinkedHashSet<>();

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLongi() {
        return longi;
    }

    public void setLongi(Float longi) {
        this.longi = longi;
    }
}
