package model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel("CarDto")
public class CarDto {

    @ApiModelProperty("ID")
    private Long id;
    // пиши доку
    private String producer;
    private String model;
    private String country;
    private LocalDate producingDate;
    private LocalDate startProducing;
    private LocalDate endProducing;

}
