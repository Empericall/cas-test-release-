package model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("CarBrandDto")
public class CarBrandDto {

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("Название")
    private String name;

    @ApiModelProperty("Страна")
    private String country;
}
