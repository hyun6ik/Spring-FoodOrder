package com.example.foodorder.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 20)
    private String shopName;

    @Length(max = 40)
    private String shopAddress;

    @OneToMany(mappedBy = "shop", cascade = ALL, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = ALL, orphanRemoval = true)
    private List<Orders> ordersList = new ArrayList<>();


    public Shop(String shopName, String shopAddress) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public static Shop of(String shopName, String shopAddress) {
        return new Shop(shopName, shopAddress);
    }
}
