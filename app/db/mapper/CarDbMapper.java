package db.mapper;

import model.entity.CarEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarDbMapper {

    @Select("SELECT * FROM cars c WHERE c.id = #{id}")
    @Results(id = "CarResults", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "producer", property = "producer"),
            @Result(column = "model", property = "model"),
            @Result(column = "country", property = "country"),
            @Result(column = "producing_date", property = "producingDate"),
            @Result(column = "start_producing", property = "startProducing"),
            @Result(column = "end_producing", property = "endProducing")
    })
    CarEntity findById(Long id);

    @Select("SELECT * FROM cars")
    @Results(id = "CarResults")
    List<CarEntity> findAll();

    @Delete("DELETE FROM cars WHERE id = #{id}")
    void deleteById(Long id);

    @Insert("INSERT INTO cars(" +
            "producer, " +
            "model, " +
            "country, " +
            "producing_date," +
            "start_producing," +
            "end_producing" +
            ") VALUES(" +
            "#{entity.producer}," +
            "#{entity.model}," +
            "#{entity.country}," +
            "#{entity.producingDate}," +
            "#{entity.startProducing}," +
            "#{entity.endProducing}" +
            ")")
    void insert(CarEntity entity);

    @Update("UPDATE cars SET " +
            "producer = #{entity.producer}," +
            "model = #{entity.model}," +
            "country = #{entity.country}," +
            "producing_date = #{entity.producingDate}," +
            "start_producing = #{entity.startProducing}," +
            "end_producing = #{entity.endProducing} " +
            "WHERE id = #{entity.id}")
    void update(CarEntity entity);

}
