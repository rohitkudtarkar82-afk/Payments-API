package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Handling;

public interface HandlingRepository extends JpaRepository<Handling, String> {

}
