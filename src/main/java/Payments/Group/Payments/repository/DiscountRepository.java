package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, String> {

}
