package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Order;
import com.poly.entity.User;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
	@Query("select o from Order o where o.user = :id")
	public List<Order> getOrder(@Param("id") User user);
	@Query("select o from Order o where o.status = :status")
	List<Order> getOrderbyStatus(@Param("status") Integer status);

}
