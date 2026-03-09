package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Venmo;

public interface VenmoRepository extends JpaRepository<Venmo, String> {

}
