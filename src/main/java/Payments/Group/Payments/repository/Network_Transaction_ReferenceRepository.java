package Payments.Group.Payments.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Network_Transaction_Reference;

public interface Network_Transaction_ReferenceRepository extends JpaRepository<Network_Transaction_Reference, UUID> {

}
