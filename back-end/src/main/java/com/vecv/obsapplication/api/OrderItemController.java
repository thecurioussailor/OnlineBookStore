package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.OrderItem;
import com.vecv.obsapplication.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderItemController {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping("/orderitems")
    public List<OrderItem> orderItemList() {
        return orderItemRepository.findAll();
    }

    @GetMapping("/orderitems/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            return ResponseEntity.ok(optionalOrderItem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/orderitems")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemRepository.save(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
    }

    @PutMapping("/orderitems/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem updatedOrderItem) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();
            // Update the order item attributes based on the updatedOrderItem object
            orderItem.setQuantity(updatedOrderItem.getQuantity());



            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
            return ResponseEntity.ok(savedOrderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/orderitems/{orderItemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            orderItemRepository.deleteById(orderItemId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

