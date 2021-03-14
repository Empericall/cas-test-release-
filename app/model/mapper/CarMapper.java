package model.mapper;

import model.dto.CarDto;
import model.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jsr330")
public interface CarMapper {

    CarEntity toEntity(CarDto dto);
    CarDto toDto(CarEntity entity);

    List<CarEntity> toEntity(List<CarDto> list);
    List<CarDto> toDto(List<CarEntity> list);

}
