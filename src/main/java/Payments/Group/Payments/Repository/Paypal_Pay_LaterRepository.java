package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal_Pay_Later;

public interface Paypal_Pay_LaterRepository extends JpaRepository<Paypal_Pay_Later, UUID> {

}
