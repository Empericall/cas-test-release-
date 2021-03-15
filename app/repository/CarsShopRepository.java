package repository;

import com.google.inject.ImplementedBy;
import model.entity.CarForSaleEntity;
import repository.impl.CarsShopRepositoryImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(CarsShopRepositoryImpl.class)
public interface CarsShopRepository {

    CompletionStage<CarForSaleEntity> findById(Long id);
    CompletionStage<List<CarForSaleEntity>> findAll();
    CompletionStage<Void> deleteById(Long id);
    CompletionStage<Void> insert(CarForSaleEntity entity);
    CompletionStage<Void> update(CarForSaleEntity entity);

}
