package me.adamatraore.InterventionManager.entity;


import javax.persistence.*;

@Entity
public class Speaker {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rfIdAssemblee")
  private Assembly assembly;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
}
