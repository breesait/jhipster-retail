package com.prosidney.retail.web.rest;

import static java.util.stream.Collectors.toList;

import com.prosidney.retail.inventory.InventoryRestClient;
import com.prosidney.retail.inventory.Product;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AvailableProductResource {

    private final InventoryRestClient inventoryRestClient;

    public AvailableProductResource(final InventoryRestClient accountingRestClient) {
        this.inventoryRestClient = accountingRestClient;
    }

    @GetMapping("/available-products")
    public List<Product> getAvailableProducts() {
        final List<Product> products = inventoryRestClient.getProducts();

        final List<Product> availableProducts = products.stream().filter(order -> order.getQuantity() > 0).collect(toList());

        return availableProducts;
    }
}
