package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {

}
