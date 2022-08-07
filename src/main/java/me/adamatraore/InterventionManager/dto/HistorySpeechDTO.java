package me.adamatraore.InterventionManager.dto;


import java.sql.Date;

public class HistorySpeechDTO {

  private Long id;

  private Date date;

  private SpeechDTO speech;

  private SpeakerDTO speaker;

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

  public SpeechDTO getSpeech() {
    return speech;
  }

  public void setSpeech(SpeechDTO speech) {
    this.speech = speech;
  }

  public SpeakerDTO getSpeaker() {
    return speaker;
  }

  public void setSpeaker(SpeakerDTO speaker) {
    this.speaker = speaker;
  }
}
