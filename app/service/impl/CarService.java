package service.impl;

import model.dto.CarDto;

import java.util.List;
import java.util.concurrent.CompletionStage;

public interface CarService {

    CompletionStage<CarDto> getById(Long id);
    CompletionStage<List<CarDto>> getAll();
    CompletionStage<Void> save(CarDto dto);
    CompletionStage<Void> update(CarDto dto);

}
