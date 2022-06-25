package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.Speech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeechRepository extends JpaRepository<Speech, Integer> {
    @Override
    List<Speech> findAll();
}
