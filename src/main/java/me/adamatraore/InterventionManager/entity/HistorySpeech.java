package me.adamatraore.InterventionManager.entity;


import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "history_speech")
@Entity
public class HistorySpeech {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "date")
  private Date date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "speech_id")
  private Speech speech;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "speaker_id")
  private Speaker speaker;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Speech getSpeech() {
    return speech;
  }

  public void setSpeech(Speech speech) {
    this.speech = speech;
  }

  public Speaker getSpeaker() {
    return speaker;
  }

  public void setSpeaker(Speaker speaker) {
    this.speaker = speaker;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    HistorySpeech speaker = (HistorySpeech) o;
    return id != null && Objects.equals(id, speaker.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
