package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal;

public interface PaypalRepository extends JpaRepository<Paypal, String> {

}
