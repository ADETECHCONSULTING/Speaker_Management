package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.Speech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeechRepository extends JpaRepository<Speech, Integer> {
    @Override
    List<Speech> findAll();

    @Query(nativeQuery = true, value = "select * from speech order by name asc")
    List<Speech> findAllOrderByNameAsc();

    @Query(nativeQuery = true, value = "select speech.* from speech left join history_speech ss on speech.id = ss.speech_id where (ss.date is null OR ss.date < DATE_SUB(CURDATE(), INTERVAL 2 YEAR))")
    List<Speech> findAllSpeechLessThanTwoYears();
}
