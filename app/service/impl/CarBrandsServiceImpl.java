package service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;
import model.dto.CarBrandDto;
import model.mapper.CarBrandMapper;
import repository.impl.CarBrandsRepositoryImpl;
import service.CarBrandsService;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CarBrandsServiceImpl implements CarBrandsService {

    private final CarBrandsRepositoryImpl repository;
    private final CarBrandMapper mapper;

    @Override
    public CompletionStage<CarBrandDto> getById(Long id) {
        return repository.findById(id).thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<List<CarBrandDto>> getAll() {
        return repository.findAll().thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<Void> save(CarBrandDto dto) {
        return repository.insert(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> update(CarBrandDto dto) {
        return repository.update(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> delete(CarBrandDto dto) {
        return repository.deleteById(mapper.toEntity(dto).getId());
    }


}
