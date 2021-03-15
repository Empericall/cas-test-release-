package model.mapper;

import model.dto.CarForSaleDto;
import model.dto.CarModelDto;
import model.entity.CarForSaleEntity;
import model.entity.CarModelEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Emperical
 * */
@Mapper(componentModel = "jsr330")
public interface CarForSaleMapper {

    CarForSaleEntity toEntity(CarForSaleDto dto);
    CarForSaleDto toDto(CarForSaleEntity entity);

    List<CarForSaleEntity> toEntity(List<CarForSaleDto> list);
    List<CarForSaleDto> toDto(List<CarForSaleEntity> list);

}
