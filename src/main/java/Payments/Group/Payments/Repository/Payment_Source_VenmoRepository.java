package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payment_Source_Venmo;

public interface Payment_Source_VenmoRepository extends JpaRepository<Payment_Source_Venmo, UUID> {

}
