package model;

import lombok.RequiredArgsConstructor;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

/**
 * @author Emperical
 * */
@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class DataSourceProvider implements Provider<DataSource> {

    private final Database database;

    @Override
    public DataSource get() {
        return database.getDataSource();
    }
}
