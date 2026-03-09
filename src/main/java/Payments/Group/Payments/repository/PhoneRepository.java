package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
