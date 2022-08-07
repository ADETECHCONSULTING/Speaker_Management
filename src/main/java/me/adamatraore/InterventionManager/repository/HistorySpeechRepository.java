package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.HistorySpeech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorySpeechRepository extends JpaRepository<HistorySpeech, Integer> {
    @Override
    List<HistorySpeech> findAll();

    @Query(nativeQuery = true, value = "select * from history_speech order by date desc")
    List<HistorySpeech> findAllOrderByDateDesc();
}
