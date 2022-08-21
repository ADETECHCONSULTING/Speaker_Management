package me.adamatraore.InterventionManager.repository;

import me.adamatraore.InterventionManager.entity.Assembly;
import me.adamatraore.InterventionManager.entity.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssemblyRepository extends JpaRepository<Assembly, Integer> {
    @Override
    List<Assembly> findAll();

    Assembly findFirstByName(String name);
}
