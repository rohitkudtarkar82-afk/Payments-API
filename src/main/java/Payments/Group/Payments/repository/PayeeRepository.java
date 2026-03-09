package Payments.Group.Payments.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payee;

public interface PayeeRepository extends JpaRepository<Payee, UUID> {

}
