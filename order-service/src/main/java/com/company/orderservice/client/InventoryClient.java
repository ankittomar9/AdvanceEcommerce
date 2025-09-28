package com.company.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "inventory", url = "http://localhost:8082") for localhost
//@FeignClient(value = "inventory", url = "http://inventory-service:8082") //for docker
@FeignClient(value = "inventory", url = "${inventory.service.url}") //for docker


public interface InventoryClient {

//    @GetMapping
//    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
        @RequestMapping(method = RequestMethod.GET,value = "/api/inventory")
        boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
