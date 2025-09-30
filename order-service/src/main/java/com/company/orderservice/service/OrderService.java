package com.company.orderservice.service;

import com.company.orderservice.client.InventoryClient;
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
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        //Testing using either WireMOCK or Mockito
        //1 using Mockito
        //2 UseWireMock
        var isProductInStock =inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
    //map OrderRequest to Order Object
        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());

            //save order to OrderRepository
            orderRepository.save(order);
        }else{
            throw new RuntimeException("Product with SkuCode " +orderRequest.skuCode()+ " is not in stock ");
        }


    }

}
