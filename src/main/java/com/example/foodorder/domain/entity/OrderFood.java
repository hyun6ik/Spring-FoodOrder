package com.example.foodorder.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public OrderFood(String foodName) {
        this.foodName = foodName;
    }

    public static OrderFood of(String foodName) {
        return new OrderFood(foodName);
    }


    public void addOrders(Orders orders) {
        this.orders =orders;
    }
}
