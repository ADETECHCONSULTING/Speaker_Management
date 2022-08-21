package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.Speaker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class, uses = {IAssemblyMapper.class, ISpeechMapper.class})
public interface ISpeakerMapper extends IAbstractMapper<Speaker, SpeakerDTO> {

    @Override
    @Mapping(source = "assembly", target = "assembly.name")
    Speaker mapFrom(SpeakerDTO source);

    @Override
    @Mapping(target = "assembly", source = "assembly.name")
    SpeakerDTO mapTo(Speaker target);
}
