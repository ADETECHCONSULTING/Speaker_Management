package me.adamatraore.InterventionManager.dto;

import java.io.Serializable;

public class SpeechDTO implements Serializable {
    private Integer id;
    private String name;
    private ThemeDTO theme;

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

    public ThemeDTO getTheme() {
        return theme;
    }

    public void setTheme(ThemeDTO theme) {
        this.theme = theme;
    }
}
