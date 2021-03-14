package repository;

import com.google.inject.ImplementedBy;
import model.entity.CarEntity;
import repository.impl.CarRepositoryImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ImplementedBy(CarRepositoryImpl.class)
public interface CarRepository {

    CompletionStage<CarEntity> findById(Long id);
    CompletionStage<List<CarEntity>> findAll();
    CompletionStage<Void> deleteById(Long id);
    CompletionStage<Void> insert(CarEntity entity);
    CompletionStage<Void> update(CarEntity entity);

}
