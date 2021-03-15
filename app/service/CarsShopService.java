package service;

import com.google.inject.ImplementedBy;
import model.dto.CarForSaleDto;
import service.impl.CarsShopServiceImpl;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@ImplementedBy(CarsShopServiceImpl.class)
public interface CarsShopService {

    CompletionStage<CarForSaleDto> getById(Long id);
    CompletionStage<List<CarForSaleDto>> getAll();
    CompletionStage<Void> save(CarForSaleDto dto);
    CompletionStage<Void> update(CarForSaleDto dto);
    CompletionStage<Void> delete(CarForSaleDto dto);

}
