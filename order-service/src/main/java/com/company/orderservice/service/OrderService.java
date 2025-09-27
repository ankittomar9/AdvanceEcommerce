package com.company.orderservice.service;

import com.company.orderservice.dto.OrderRequest;
import com.company.orderservice.model.Order;
import com.company.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository   orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
    //map OrderRequest to Order Object
        Order order =new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());

        //save order to OrderRepository
        orderRepository.save(order);



    }

}
