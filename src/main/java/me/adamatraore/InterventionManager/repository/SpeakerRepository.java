package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
    @Override
    List<Speaker> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM speaker")
    List<Speaker> findAllByHistory();
}
