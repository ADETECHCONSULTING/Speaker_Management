package me.adamatraore.InterventionManager.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "Speaker")
@Entity
public class Speaker {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  //un orateur ne peut avoir qu'une assemblée
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assembly_id")
  private Assembly assembly;

  //un orateur peut avoir un ou plusieurs discours
  @ManyToMany
  @JoinTable(name = "speaker_speech",
          joinColumns = @JoinColumn(name = "speaker_id"),
          inverseJoinColumns = @JoinColumn(name = "speech_id"))
  private Set<Speech> speeches = new LinkedHashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Assembly getAssembly() {
    return assembly;
  }

  public void setAssembly(Assembly assembly) {
    this.assembly = assembly;
  }

  public Set<Speech> getSpeeches() {
    return speeches;
  }

  public void setSpeeches(Set<Speech> speeches) {
    this.speeches = speeches;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Speaker speaker = (Speaker) o;
    return id != null && Objects.equals(id, speaker.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
