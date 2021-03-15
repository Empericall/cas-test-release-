package service;

import com.google.inject.ImplementedBy;
import model.dto.CarBrandDto;
import service.impl.CarBrandsServiceImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@ImplementedBy(CarBrandsServiceImpl.class)
public interface CarBrandsService {

    CompletionStage<CarBrandDto> getById(Long id);
    CompletionStage<List<CarBrandDto>> getAll();
    CompletionStage<Void> save(CarBrandDto dto);
    CompletionStage<Void> update(CarBrandDto dto);
    CompletionStage<Void> delete(CarBrandDto dto);

}
