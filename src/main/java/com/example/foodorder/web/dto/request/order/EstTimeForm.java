package com.example.foodorder.web.dto.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstTimeForm {

    private int estimatedTime;
    private Long orderId;
}
