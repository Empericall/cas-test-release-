package repository.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import db.mapper.CarDbMapper;
import lombok.RequiredArgsConstructor;
import model.entity.CarEntity;
import repository.CarRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class CarRepositoryImpl implements CarRepository {

    private final CarDbMapper mapper;

    @Override
    public CompletionStage<CarEntity> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> mapper.findById(id));
    }

    @Override
    public CompletionStage<List<CarEntity>> findAll() {
        return CompletableFuture.supplyAsync(() -> mapper.findAll());
    }

    @Override
    public CompletionStage<Void> deleteById(Long id) {
        return CompletableFuture.runAsync(() -> mapper.deleteById(id));
    }

    @Override
    public CompletionStage<Void> insert(CarEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.insert(entity));
    }

    @Override
    public CompletionStage<Void> update(CarEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.update(entity));
    }
}
