package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal_Credit;

public interface Paypal_CreditRepository extends JpaRepository<Paypal_Credit, String> {

}
