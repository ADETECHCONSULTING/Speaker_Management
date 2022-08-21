package me.adamatraore.InterventionManager.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class SpeakerDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String assembly;

    private Set<SpeechDTO> speeches = new LinkedHashSet<>();

    public SpeakerDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public Set<SpeechDTO> getSpeeches() {
        return speeches;
    }

    public void setSpeeches(Set<SpeechDTO> speeches) {
        this.speeches = speeches;
    }
}
