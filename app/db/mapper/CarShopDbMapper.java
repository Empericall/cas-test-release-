package db.mapper;

import model.entity.CarForSaleEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CarShopDbMapper {

    @Select("SELECT * FROM cars_shop cs WHERE cs.id = #{id}")
    @Results(id = "CarsShopResults", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "car_brand", property = "carBrand"),
            @Result(column = "car_model", property = "carModel"),
            @Result(column = "producing_date", property = "producingDate"),
            @Result(column = "milesage", property = "milesage"),
            @Result(column = "price", property = "price")
    })
    CarForSaleEntity findById(Long id);

    @Select("SELECT * FROM cars_shop")
    @ResultMap("CarsShopResults")
    List<CarForSaleEntity> findAll();

    @Delete("DELETE FROM cars_shop WHERE id = #{id}")
    void deleteById(Long id);

    @Insert("INSERT INTO cars_shop(" +
            "car_brand, " +
            "car_model, " +
            "producing_date, " +
            "milesage," +
            "price" +
            ") VALUES(" +
            "#{entity.carBrand}," +
            "#{entity.carModel}," +
            "#{entity.producingDate}," +
            "#{entity.milesage}," +
            "#{entity.price}" +
            ")")
    void insert(CarForSaleEntity entity);

    @Update("UPDATE cars_shop SET " +
            "car_brand = #{entity.carBrand}," +
            "car_model = #{entity.carModel}," +
            "producing_date = #{entity.producingDate}," +
            "milesage = #{entity.milesage}," +
            "price = #{entity.price} " +
            "WHERE id = #{entity.id}")
    void update(CarForSaleEntity entity);

}
