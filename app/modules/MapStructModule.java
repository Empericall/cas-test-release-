package modules;

import com.google.inject.AbstractModule;
import model.mapper.CarBrandMapper;
import model.mapper.CarForSaleMapper;
import model.mapper.CarModelMapper;
import org.mapstruct.factory.Mappers;

public class MapStructModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CarBrandMapper.class).toInstance(Mappers.getMapper(CarBrandMapper.class));
        bind(CarModelMapper.class).toInstance(Mappers.getMapper(CarModelMapper.class));
        bind(CarForSaleMapper.class).toInstance(Mappers.getMapper(CarForSaleMapper.class));
    }

}
