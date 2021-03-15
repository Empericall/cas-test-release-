package model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Emperical
 * */
@Data
public class CarForSaleEntity {
    private Long id;
    private Long carBrand;
    private Long carModel;
    private LocalDate producingDate;
    private Integer milesage;
    private BigDecimal price;
}
