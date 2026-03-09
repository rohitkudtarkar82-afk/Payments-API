package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Net_Amount;

public interface Net_AmountRepository extends JpaRepository<Net_Amount, String> {

}
