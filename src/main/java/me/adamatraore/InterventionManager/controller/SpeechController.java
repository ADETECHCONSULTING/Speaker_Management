package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.dto.HistorySpeechDTO;
import me.adamatraore.InterventionManager.dto.SpeechDTO;
import me.adamatraore.InterventionManager.entity.Assembly;
import me.adamatraore.InterventionManager.entity.HistorySpeech;
import me.adamatraore.InterventionManager.entity.Speech;
import me.adamatraore.InterventionManager.mapper.IHistorySpeechMapper;
import me.adamatraore.InterventionManager.mapper.ISpeechMapper;
import me.adamatraore.InterventionManager.repository.HistorySpeechRepository;
import me.adamatraore.InterventionManager.repository.SpeechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class SpeechController {

    @Autowired
    private SpeechRepository speechRepository;
    @Autowired
    private ISpeechMapper speechMapper;

    @Autowired
    private HistorySpeechRepository historySpeechRepository;
    @Autowired
    private IHistorySpeechMapper historySpeechMapper;

    @GetMapping("/speech/all")
    public List<SpeechDTO> getSpeeches() {
        List<Speech> speeches = speechRepository.findAllOrderByNameAsc();
        return speechMapper.mapListTo(speeches);
    }

    @GetMapping("/speech/available")
    public List<SpeechDTO> getAvailableSpeeches() {
        List<Speech> speeches = speechRepository.findAllSpeechLessThanTwoYears();
        return speechMapper.mapListTo(speeches);
    }

    @GetMapping("/speech/history")
    public List<HistorySpeechDTO> getHistorySpeeches() {
        List<HistorySpeech> historySpeeches = historySpeechRepository.findAllOrderByDateDesc();
        return historySpeechMapper.mapListTo(historySpeeches);
    }

    @PostMapping(value = "/speech/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSpeechHistory(@RequestBody HistorySpeechDTO body) {
        HistorySpeech historySpeech = historySpeechMapper.mapFrom(body);
        historySpeechRepository.save(historySpeech);
    }

    @PostMapping(value = "/speech", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSpeech(@RequestBody SpeechDTO body) {
        speechRepository.save(speechMapper.mapFrom(body));
    }

    @PutMapping(value = "/speech")
    public void updateSpeech(@RequestBody SpeechDTO body) {
        speechRepository.save(speechMapper.mapFrom(body));
    }

    @DeleteMapping(value = "/speech/{id}")
    public void deleteSpeech(@PathVariable Integer id) {
        speechRepository.deleteById(id);
    }
}
