package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Seller_Protection;

public interface Seller_ProtectionRepository extends JpaRepository<Seller_Protection, UUID> {

}
