package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Receivable_Amount;

public interface Receivable_AmountRepository extends JpaRepository<Receivable_Amount, UUID> {

}
