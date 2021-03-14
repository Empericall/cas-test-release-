package modules;

import com.google.inject.AbstractModule;
import model.mapper.CarMapper;
import org.mapstruct.factory.Mappers;

public class MapStructModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CarMapper.class).toInstance(Mappers.getMapper(CarMapper.class));
    }

}
