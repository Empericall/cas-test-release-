package db.mapper;

import model.entity.CarModelEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Emperical
 * */
@Mapper
public interface CarModelsDbMapper {

    @Select("SELECT * FROM car_models cm WHERE cm.id = #{id}")
    @Results(id = "CarModelsResults", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "producing_started", property = "producingStarted"),
            @Result(column = "producing_end", property = "producingEnd")
    })
    CarModelEntity findById(Long id);

    @Select("SELECT * FROM car_models")
    @ResultMap("CarModelsResults")
    List<CarModelEntity> findAll();

    @Delete("DELETE FROM car_models WHERE id = #{id}")
    void deleteById(Long id);

    @Insert("INSERT INTO car_models(" +
            "name, " +
            "producing_started, " +
            "producing_end" +
            ") VALUES(" +
            "#{name}," +
            "#{producingStarted}," +
            "#{producingEnd}" +
            ")")
    void insert(CarModelEntity entity);

    @Update("UPDATE car_models SET " +
            "name = #{name}," +
            "producing_started = #{producingStarted}," +
            "producing_end = #{producingEnd} " +
            "WHERE id = #{id}")
    void update(CarModelEntity entity);

}
