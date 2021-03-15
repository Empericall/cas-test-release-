package model.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Emperical
 * */
@Data
public class CarModelEntity {
    private Long id;
    private String name;
    private LocalDate producingStarted;
    private LocalDate producingEnd;
}
