package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Converted_Amount;

public interface Converted_AmountRepository extends JpaRepository<Converted_Amount, UUID> {

}
