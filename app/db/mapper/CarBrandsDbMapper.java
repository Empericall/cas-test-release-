package db.mapper;

import model.entity.CarBrandEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarBrandsDbMapper {

    @Select("SELECT * FROM car_brands cb WHERE cb.id = #{id}")
    @Results(id = "CarBrandsResults", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "country", property = "country")
    })
    CarBrandEntity findById(Long id);

    @Select("SELECT * FROM car_brands")
    @ResultMap("CarBrandsResults")
    List<CarBrandEntity> findAll();

    @Delete("DELETE FROM car_brands WHERE id = #{id}")
    void deleteById(Long id);

    @Insert("INSERT INTO car_brands(" +
            "name, " +
            "country" +
            ") VALUES(" +
            "#{entity.name}," +
            "#{entity.country}" +
            ")")
    void insert(CarBrandEntity entity);

    @Update("UPDATE car_brands SET " +
            "name = #{entity.name}," +
            "country = #{entity.country} " +
            "WHERE id = #{entity.id}")
    void update(CarBrandEntity entity);

}
