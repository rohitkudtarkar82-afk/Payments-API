package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Exchange_Rate;

public interface Exchange_RateRepository extends JpaRepository<Exchange_Rate, UUID> {

}
