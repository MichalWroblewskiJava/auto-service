package pl.sda.javagdy2.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Custamer implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Integer cars_qty;
    private Boolean tips;
    private Integer rate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "custamer")
    private List<Order> orderList;
}