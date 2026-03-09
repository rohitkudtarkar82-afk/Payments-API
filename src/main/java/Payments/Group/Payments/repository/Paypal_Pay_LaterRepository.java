package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal_Pay_Later;

public interface Paypal_Pay_LaterRepository extends JpaRepository<Paypal_Pay_Later, String> {

}
