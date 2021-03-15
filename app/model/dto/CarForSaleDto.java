package model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ApiModel("CarForSaleDto")
public class CarForSaleDto {
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("Автопроизводитель (бренд)")
    private Long carBrand;

    @ApiModelProperty("Модель")
    private Long carModel;

    @ApiModelProperty("Год выпуска")
    private LocalDate producingDate;

    @ApiModelProperty("Пробег")
    private Integer milesage;

    @ApiModelProperty("Цена")
    private BigDecimal price;
}
