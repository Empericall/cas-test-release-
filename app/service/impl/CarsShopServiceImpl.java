package service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;
import model.dto.CarForSaleDto;
import model.dto.CarModelDto;
import model.mapper.CarForSaleMapper;
import repository.impl.CarsShopRepositoryImpl;
import service.CarsShopService;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CarsShopServiceImpl implements CarsShopService {

    private final CarsShopRepositoryImpl repository;
    private final CarForSaleMapper mapper;

    @Override
    public CompletionStage<CarForSaleDto> getById(Long id) {
        return repository.findById(id).thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<List<CarForSaleDto>> getAll() {
        return repository.findAll().thenApply(mapper::toDto);
    }

    @Override
    public CompletionStage<Void> save(CarForSaleDto dto) {
        return repository.insert(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> update(CarForSaleDto dto) {
        return repository.update(mapper.toEntity(dto));
    }

    @Override
    public CompletionStage<Void> delete(CarForSaleDto dto) {
        return repository.deleteById(mapper.toEntity(dto).getId());
    }
}
