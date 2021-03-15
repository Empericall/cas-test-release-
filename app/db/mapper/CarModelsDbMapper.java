package db.mapper;

import model.entity.CarModelEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

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
            "#{entity.name}," +
            "#{entity.producingStarted}," +
            "#{entity.producingEnd}" +
            ")")
    void insert(CarModelEntity entity);

    @Update("UPDATE car_models SET " +
            "name = #{entity.name}," +
            "producing_started = #{entity.producingStarted}," +
            "producing_end = #{entity.producingEnd} " +
            "WHERE id = #{entity.id}")
    void update(CarModelEntity entity);

}
