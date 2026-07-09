package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.client.CustomerClient;
import com.stringwavetech.ecommerce.client.PaymentClient;
import com.stringwavetech.ecommerce.client.ProductClient;
import com.stringwavetech.ecommerce.exceptions.BusinessException;
import com.stringwavetech.ecommerce.exceptions.NotFoundException;
import com.stringwavetech.ecommerce.kafka.OrderProducer;
import com.stringwavetech.ecommerce.mapper.OrderMapper;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.OrderConfirmation;
import com.stringwavetech.ecommerce.model.request.OrderLineRequestModel;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.request.PaymentRequestModel;
import com.stringwavetech.ecommerce.model.request.PurchaseRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;
import com.stringwavetech.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public BaseResponseModel<String> createOrder(OrderRequestModel request) {

        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("No customer exists with ID: " + request.customerId()));

        var purchasedProducts = productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequestModel purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequestModel(
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        var paymentRequest = new PaymentRequestModel(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return BaseResponseModel.success("Action Successfully", null);
    }

    @Override
    public BaseResponseModel<List<OrderResponseModel>> getAllOrders() {

        List<OrderResponseModel> orders = repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .toList();

        return BaseResponseModel.success("Action Successfully", orders);
    }

    @Override
    public BaseResponseModel<OrderResponseModel> getOrder(String orderId) {

        OrderResponseModel order = this.repository.findById(UUID.fromString(orderId))
                .map(this.mapper::fromOrder)
                .orElseThrow(() ->
                        new NotFoundException("No order found with the provided ID: " + orderId)
                );

        return BaseResponseModel.success("Action Successfully", order);
    }
}
