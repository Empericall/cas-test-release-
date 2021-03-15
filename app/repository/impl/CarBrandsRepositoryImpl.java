package repository.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import db.mapper.CarBrandsDbMapper;
import lombok.RequiredArgsConstructor;
import model.entity.CarBrandEntity;
import repository.CarBrandsRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject})
public class CarBrandsRepositoryImpl implements CarBrandsRepository {

    private final CarBrandsDbMapper mapper;

    @Override
    public CompletionStage<CarBrandEntity> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> mapper.findById(id));
    }

    @Override
    public CompletionStage<List<CarBrandEntity>> findAll() {
        return CompletableFuture.supplyAsync(() -> mapper.findAll());
    }

    @Override
    public CompletionStage<Void> deleteById(Long id) {
        return CompletableFuture.runAsync(() -> mapper.deleteById(id));
    }

    @Override
    public CompletionStage<Void> insert(CarBrandEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.insert(entity));
    }

    @Override
    public CompletionStage<Void> update(CarBrandEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.update(entity));
    }
}
