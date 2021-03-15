package service;

import com.google.inject.ImplementedBy;
import model.dto.CarModelDto;
import service.impl.CarModelsServiceImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(CarModelsServiceImpl.class)
public interface CarModelsService {

    CompletionStage<CarModelDto> getById(Long id);
    CompletionStage<List<CarModelDto>> getAll();
    CompletionStage<Void> save(CarModelDto dto);
    CompletionStage<Void> update(CarModelDto dto);
    CompletionStage<Void> delete(CarModelDto dto);

}
