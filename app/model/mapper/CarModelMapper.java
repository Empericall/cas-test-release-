package model.mapper;

import model.dto.CarBrandDto;
import model.dto.CarModelDto;
import model.entity.CarBrandEntity;
import model.entity.CarModelEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Emperical
 * */
@Mapper(componentModel = "jsr330")
public interface CarModelMapper {

    CarModelEntity toEntity(CarModelDto dto);
    CarModelDto toDto(CarModelEntity entity);

    List<CarModelEntity> toEntity(List<CarModelDto> list);
    List<CarModelDto> toDto(List<CarModelEntity> list);

}
