package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {

    @Override
    List<Speaker> findAll();
}
