package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Shipping_Discount;

public interface Shipping_DiscountRepository extends JpaRepository<Shipping_Discount, String> {

}
