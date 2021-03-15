package service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;
import model.dto.CarBrandDto;
import model.dto.CarModelDto;
import model.mapper.CarModelMapper;
import repository.impl.CarModelsRepositoryImpl;
import service.CarModelsService;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CarModelsServiceImpl implements CarModelsService {

    private final CarModelsRepositoryImpl repository;
    private final CarModelMapper mapper;

    @Override
    public CompletionStage<CarModelDto> getById(Long id) {
        return repository.findById(id).thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<List<CarModelDto>> getAll() {
        return repository.findAll().thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<Void> save(CarModelDto dto) {
        return repository.insert(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> update(CarModelDto dto) {
        return repository.update(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> delete(CarModelDto dto) {
        return repository.deleteById(mapper.toEntity(dto).getId());
    }
}
