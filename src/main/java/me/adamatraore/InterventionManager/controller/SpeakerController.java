package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.Speaker;
import me.adamatraore.InterventionManager.mapper.ISpeakerMapper;
import me.adamatraore.InterventionManager.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private ISpeakerMapper speakerMapper;

    @GetMapping("/speakers")
    public List<SpeakerDTO> getSpeakers() {
        List<Speaker> speakers = speakerRepository.findAll();
        return speakerMapper.mapListTo(speakers);
    }

    @PostMapping("/speaker")
    public String createSpeaker(@RequestBody Map<String, String> body) {
        return "Succès";
    }

    @PutMapping("/speaker")
    public String updateSpeaker(@RequestBody Map<String, String> body) {
        return "Succès";
    }

    @GetMapping("/speakers-by-speech/{id}")
    public List<SpeakerDTO> getSpeakersBySpeechId(@PathVariable Integer id) {
        return new ArrayList<>();
    }
}
