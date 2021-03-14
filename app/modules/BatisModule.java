package modules;

import com.google.inject.name.Names;
import db.mapper.CarDbMapper;
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
        addMapperClass(CarDbMapper.class);
        mapUnderscoreToCamelCase(true);
    }
}
