package db.mapper;

import model.entity.CarForSaleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Emperical
 * */
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
            "#{carBrand}," +
            "#{carModel}," +
            "#{producingDate}," +
            "#{milesage}," +
            "#{price}" +
            ")")
    void insert(CarForSaleEntity entity);

    @Update("UPDATE cars_shop SET " +
            "car_brand = #{carBrand}," +
            "car_model = #{carModel}," +
            "producing_date = #{producingDate}," +
            "milesage = #{milesage}," +
            "price = #{price} " +
            "WHERE id = #{id}")
    void update(CarForSaleEntity entity);

}
