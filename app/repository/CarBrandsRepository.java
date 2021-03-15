package repository;

import com.google.inject.ImplementedBy;
import model.entity.CarBrandEntity;
import repository.impl.CarBrandsRepositoryImpl;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@ImplementedBy(CarBrandsRepositoryImpl.class)
public interface CarBrandsRepository {

    CompletionStage<CarBrandEntity> findById(Long id);
    CompletionStage<List<CarBrandEntity>> findAll();
    CompletionStage<Void> deleteById(Long id);
    CompletionStage<Void> insert(CarBrandEntity entity);
    CompletionStage<Void> update(CarBrandEntity entity);

}
