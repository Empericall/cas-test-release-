package model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel("CarModelDto")
public class CarModelDto {
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("Наименование модели")
    private String name;

    @ApiModelProperty("Дата начала производства")
    private LocalDate producingStarted;

    @ApiModelProperty("Дата конца производства")
    private LocalDate producingEnd;
}
