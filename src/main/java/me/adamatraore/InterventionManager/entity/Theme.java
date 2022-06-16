package me.adamatraore.InterventionManager.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    //un theme peut avoir un ou plusieurs discours
    @OneToMany(mappedBy = "theme")
    private Set<Speech> speeches = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Speech> getSpeeches() {
        return speeches;
    }

    public void setSpeeches(Set<Speech> speeches) {
        this.speeches = speeches;
    }

}