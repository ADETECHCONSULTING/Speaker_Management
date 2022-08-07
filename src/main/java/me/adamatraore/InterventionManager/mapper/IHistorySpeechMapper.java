package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.HistorySpeechDTO;
import me.adamatraore.InterventionManager.dto.SpeakerDTO;
import me.adamatraore.InterventionManager.entity.HistorySpeech;
import me.adamatraore.InterventionManager.entity.Speaker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class, uses = {ISpeakerMapper.class, ISpeechMapper.class})
public interface IHistorySpeechMapper extends IAbstractMapper<HistorySpeech, HistorySpeechDTO> {
}
