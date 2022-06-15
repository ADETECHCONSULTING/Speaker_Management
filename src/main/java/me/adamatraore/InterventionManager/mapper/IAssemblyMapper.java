package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.AssemblyDTO;
import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.Assembly;
import me.adamatraore.InterventionManager.entity.Speaker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class)
public interface IAssemblyMapper extends IAbstractMapper<Assembly, AssemblyDTO> {
}
