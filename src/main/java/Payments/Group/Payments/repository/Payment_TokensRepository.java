package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payment_Tokens;

public interface Payment_TokensRepository extends JpaRepository<Payment_Tokens, UUID> {

}
