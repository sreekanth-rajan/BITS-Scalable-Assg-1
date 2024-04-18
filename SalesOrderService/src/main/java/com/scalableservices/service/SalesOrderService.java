package com.scalableservices.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scalableservices.datamodel.SalesOrder;
import com.scalableservices.dto.SalesOrderDTO;
import com.scalableservices.repository.SalesOrderRepository;

@Transactional
@Service
public class SalesOrderService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	public List<SalesOrderDTO> all() {
		return salesOrderRepository.findAll().stream().map(c -> modelMapper.map(c, SalesOrderDTO.class))
				.collect(Collectors.toList());
	}

	public SalesOrderDTO save(SalesOrderDTO salesOrderDTO) {
		SalesOrder salesOrder = salesOrderRepository.save(modelMapper.map(salesOrderDTO, SalesOrder.class));
		return modelMapper.map(salesOrder, SalesOrderDTO.class);
	}

	public SalesOrderDTO get(long orderId) {
		Optional<SalesOrder> orderResult = salesOrderRepository.findById(orderId);
		if (!orderResult.isPresent()) {
			return null;
		}
		return modelMapper.map(orderResult.get(), SalesOrderDTO.class);
	}

	public void delete(long orderId) {
		salesOrderRepository.deleteById(orderId);
	}
}
