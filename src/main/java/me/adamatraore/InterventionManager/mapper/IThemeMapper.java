package me.adamatraore.InterventionManager.mapper;

import me.adamatraore.InterventionManager.dto.ThemeDto;
import me.adamatraore.InterventionManager.entity.Theme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapStructMapperConfig.class)
public interface IThemeMapper extends IAbstractMapper<Theme, ThemeDto> {
}
