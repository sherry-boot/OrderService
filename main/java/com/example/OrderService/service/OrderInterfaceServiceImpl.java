package com.example.OrderService.service;

import com.example.OrderService.client.ProductServiceClient;
import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.dto.ProductDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItems;
import com.example.OrderService.mapper.OrderItemMapper;
import com.example.OrderService.mapper.OrderMapper;
import com.example.OrderService.repository.OrderItemRepository;
import com.example.OrderService.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
public class OrderInterfaceServiceImpl implements  OrderInterfaceService {

    private  final OrderRepository orderRepository;
    private  final ProductServiceClient productServiceClient;
    private  final OrderItemRepository orderItemRepository;

    OrderInterfaceServiceImpl(OrderRepository orderRepository, ProductServiceClient productServiceClient, OrderItemRepository orderItemRepository){
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
        this.orderItemRepository = orderItemRepository;


    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {

        List<OrderItems> orderItemsList = new ArrayList<>();
        //order dto -> orderId, userId.
      Order order =  OrderMapper.toEntity(orderRequestDTO);
      List<OrderItems> orderItems = OrderItemMapper.toListOfOrderItems(orderRequestDTO.getOrderItems());
     // orderRepository.save(order);
        for(OrderItems orderItem : orderItems ){

           ProductDTO product =  productServiceClient.findById(orderItem.getProductId());
           if(product!=null) {
               Double totalPrice = product.getPrice() * orderItem.getQuantity();
               OrderItems orderItems1 = OrderItemMapper.toEntityFromList(orderItem, product.getId(), totalPrice, order);
               orderItemsList.add(orderItems1);
           }
        }
       order.setOrderItems(orderItemsList);
       Order createdOrder=  orderRepository.save(order);
        return OrderMapper.toCreateOrderRepsonse(createdOrder);

    }
}
