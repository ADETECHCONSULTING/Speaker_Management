package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.SpeechDto;
import me.adamatraore.InterventionManager.entity.Speech;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class, uses = {IThemeMapper.class})
public interface ISpeechMapper extends IAbstractMapper<Speech, SpeechDto> {
}
