package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.mapper.OrderLineMapper;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;
import com.stringwavetech.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    @Override
    public BaseResponseModel<List<OrderLineResponseModel>> getAllOrderLineByOrder(String orderId) {

        List<OrderLineResponseModel> orderLines = repository
                .findAllByOrderId(UUID.fromString(orderId))
                .stream()
                .map(mapper::toOrderLineResponse)
                .toList();

        return BaseResponseModel.success("Action Successfully.", orderLines);
    }
}
