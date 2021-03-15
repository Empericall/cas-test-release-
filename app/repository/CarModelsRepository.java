package repository;

import com.google.inject.ImplementedBy;
import model.entity.CarModelEntity;
import repository.impl.CarModelsRepositoryImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(CarModelsRepositoryImpl.class)
public interface CarModelsRepository {

    CompletionStage<CarModelEntity> findById(Long id);
    CompletionStage<List<CarModelEntity>> findAll();
    CompletionStage<Void> deleteById(Long id);
    CompletionStage<Void> insert(CarModelEntity entity);
    CompletionStage<Void> update(CarModelEntity entity);

}
