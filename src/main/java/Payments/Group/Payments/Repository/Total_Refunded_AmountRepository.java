package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Total_Refunded_Amount;

public interface Total_Refunded_AmountRepository extends JpaRepository<Total_Refunded_Amount, UUID> {

}
