package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal_Fee;

public interface Paypal_FeeRepository extends JpaRepository<Paypal_Fee, String> {

}
