package model.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarEntity {

    private Long id;
    private String producer;
    private String model;
    private String country;
    private LocalDate producingDate;
    private LocalDate startProducing;
    private LocalDate endProducing;

}
