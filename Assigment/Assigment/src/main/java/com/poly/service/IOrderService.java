package com.poly.service;

import java.util.List;

import com.poly.entity.Order;
import com.poly.model.OrderDTO;

public interface IOrderService {
     OrderDTO save(OrderDTO dto);
     List<OrderDTO> order();
     OrderDTO delete(Integer id);
     List<OrderDTO> getsatus(Integer status);
     OrderDTO changesatus(Order o);
}
