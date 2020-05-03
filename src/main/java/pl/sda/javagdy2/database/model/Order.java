package pl.sda.javagdy2.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Order implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Fault fault;

    private String car_plate;

    private Boolean paid;

    @ManyToOne()
    private Customer customer;

    public Order(Fault fault,String car_plate, Boolean paid) {
        this.fault = fault;
        this.car_plate = car_plate;
        this.paid = paid;
    }
}
