package me.adamatraore.InterventionManager.controller;

import me.adamatraore.InterventionManager.dto.AssemblyDTO;
import me.adamatraore.InterventionManager.entity.Assembly;
import me.adamatraore.InterventionManager.mapper.IAssemblyMapper;
import me.adamatraore.InterventionManager.repository.AssemblyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class AssemblyController {
    @Autowired
    private AssemblyRepository assemblyRepository;
    @Autowired
    private IAssemblyMapper assemblyMapper;

    @GetMapping("/assembly/all")
    public List<AssemblyDTO> getAssemblies() {
        List<Assembly> Assemblys = assemblyRepository.findAll();
        return assemblyMapper.mapListTo(Assemblys);
    }

    @GetMapping("/assembly/all-names")
    public List<String> getAssembliesName() {
        List<Assembly> assemblys = assemblyRepository.findAll();
        return assemblys.stream().map(Assembly::getName).collect(Collectors.toList());
    }

    @PostMapping(value = "/assembly", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createAssembly(@RequestBody Assembly body) {
        assemblyRepository.save(body);
    }

    @PutMapping(value = "/assembly/{id}")
    public void updateAssembly(@PathVariable Integer id, @RequestBody Assembly body) {
        assemblyRepository.save(body);
    }

    @DeleteMapping(value = "/assembly/{id}")
    public void deleteAssembly(@PathVariable Integer id) {
        assemblyRepository.deleteById(id);
    }
}
