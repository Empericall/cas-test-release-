package repository.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import db.mapper.CarShopDbMapper;
import lombok.RequiredArgsConstructor;
import model.entity.CarForSaleEntity;
import repository.CarsShopRepository;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject})
public class CarsShopRepositoryImpl implements CarsShopRepository {

    private final CarShopDbMapper mapper;

    @Override
    public CompletionStage<CarForSaleEntity> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> mapper.findById(id));
    }

    @Override
    public CompletionStage<List<CarForSaleEntity>> findAll() {
        return CompletableFuture.supplyAsync(() -> mapper.findAll());
    }

    @Override
    public CompletionStage<Void> deleteById(Long id) {
        return CompletableFuture.runAsync(() -> mapper.deleteById(id));
    }

    @Override
    public CompletionStage<Void> insert(CarForSaleEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.insert(entity));
    }

    @Override
    public CompletionStage<Void> update(CarForSaleEntity entity) {
        return CompletableFuture.runAsync(() -> mapper.update(entity));
    }
}
