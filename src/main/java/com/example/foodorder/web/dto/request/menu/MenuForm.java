package com.example.foodorder.web.dto.request.menu;

import com.example.foodorder.domain.entity.OrderFood;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuForm {

    private String address;
    private Long shopId;
    private List<String> foodList = new ArrayList<>();
}
