package com.prosidney.retail.inventory;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventory")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    List<Product> getProducts();
}
