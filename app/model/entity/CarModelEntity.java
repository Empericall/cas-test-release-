package model.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarModelEntity {
    private Long id;
    private String name;
    private LocalDate producingStarted;
    private LocalDate producingEnd;
}
