package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.dto.SpeechDto;
import me.adamatraore.InterventionManager.entity.Speech;
import me.adamatraore.InterventionManager.mapper.ISpeechMapper;
import me.adamatraore.InterventionManager.repository.SpeechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpeechController {

    @Autowired
    private SpeechRepository speechRepository;
    @Autowired
    private ISpeechMapper speechMapper;

    @GetMapping("/speeches")
    public List<SpeechDto> getSpeeches() {
        List<Speech> speeches = speechRepository.findAll();
        return speechMapper.mapListTo(speeches);
    }

    @PostMapping(value = "/speech", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createSpeech(@RequestBody Speech body) {
        return body.getName();
    }

    @PutMapping(value = "/speech", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateSpeech(@RequestBody Speech body) {
        return body.getName();
    }
}
