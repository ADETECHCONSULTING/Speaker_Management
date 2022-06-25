package me.adamatraore.InterventionManager.dto;

import java.io.Serializable;

public class SpeechDto implements Serializable {
    private Integer id;
    private String name;
    private ThemeDto theme;

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

    public ThemeDto getTheme() {
        return theme;
    }

    public void setTheme(ThemeDto theme) {
        this.theme = theme;
    }
}
