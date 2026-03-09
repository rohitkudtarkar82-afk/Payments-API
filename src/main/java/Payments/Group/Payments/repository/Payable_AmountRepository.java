package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payable_Amount;

public interface Payable_AmountRepository extends JpaRepository<Payable_Amount, String> {

}
