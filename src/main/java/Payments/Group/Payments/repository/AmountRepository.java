package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Amount;

public interface AmountRepository extends JpaRepository<Amount, String> {

}
