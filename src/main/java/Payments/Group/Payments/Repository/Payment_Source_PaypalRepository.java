package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payment_Source_Paypal;

public interface Payment_Source_PaypalRepository extends JpaRepository<Payment_Source_Paypal, UUID> {

}
