package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, String> {

}
