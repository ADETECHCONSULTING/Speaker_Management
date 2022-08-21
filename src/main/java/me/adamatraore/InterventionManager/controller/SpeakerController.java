package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.Assembly;
import me.adamatraore.InterventionManager.entity.Speaker;
import me.adamatraore.InterventionManager.mapper.ISpeakerMapper;
import me.adamatraore.InterventionManager.repository.AssemblyRepository;
import me.adamatraore.InterventionManager.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;
    @Autowired
    private AssemblyRepository assemblyRepository;
    @Autowired
    private ISpeakerMapper speakerMapper;

    @GetMapping("/speaker/all")
    public List<SpeakerDTO> getSpeakers() {
        List<Speaker> speakers = speakerRepository.findAllByHistory();
        return speakerMapper.mapListTo(speakers);
    }

    @PostMapping(value = "/speaker", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSpeaker(@RequestBody SpeakerDTO body) {
        Speaker speaker = speakerMapper.mapFrom(body);
        Assembly assembly = assemblyRepository.findFirstByName(body.getAssembly());
        if (assembly != null) {
            speaker.setAssembly(assembly);
        }
        speakerRepository.save(speaker);
    }

    @PutMapping(value = "/speaker")
    public void updateSpeaker(@RequestBody SpeakerDTO body) {
        Speaker speaker = speakerMapper.mapFrom(body);
        Assembly assembly = assemblyRepository.findFirstByName(body.getAssembly());
        if (assembly != null) {
            speaker.setAssembly(assembly);
        }
        speakerRepository.save(speaker);
    }

    @GetMapping("/speakers-by-speech/{id}")
    public List<SpeakerDTO> getSpeakersBySpeechId(@PathVariable Integer id) {
        return new ArrayList<>();
    }

    @DeleteMapping(value = "/speaker/{id}")
    public void deleteSpeaker(@PathVariable Integer id) {
        speakerRepository.deleteById(id);
    }
}
