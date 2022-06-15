package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.Speaker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class, uses = {IAssemblyMapper.class})
public interface ISpeakerMapper extends IAbstractMapper<Speaker, SpeakerDTO> {
}
