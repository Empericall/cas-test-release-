package modules;

import com.google.inject.name.Names;
import db.mapper.CarBrandsDbMapper;
import db.mapper.CarModelsDbMapper;
import db.mapper.CarShopDbMapper;
import model.DataSourceProvider;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

public class BatisModule extends MyBatisModule {
    @Override
    protected void initialize() {
        environmentId("development");
        bindConstant().annotatedWith(Names.named("mybatis.configuration.failFast")).to(true);
        bindDataSourceProviderType(DataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        addMapperClass(CarBrandsDbMapper.class);
        addMapperClass(CarModelsDbMapper.class);
        addMapperClass(CarShopDbMapper.class);
        mapUnderscoreToCamelCase(true);
    }
}
