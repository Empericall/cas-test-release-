package model.mapper;

import model.dto.CarBrandDto;
import model.entity.CarBrandEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Emperical
 * */
@Mapper(componentModel = "jsr330")
public interface CarBrandMapper {

    CarBrandEntity toEntity(CarBrandDto dto);
    CarBrandDto toDto(CarBrandEntity entity);

    List<CarBrandEntity> toEntity(List<CarBrandDto> list);
    List<CarBrandDto> toDto(List<CarBrandEntity> list);

}
