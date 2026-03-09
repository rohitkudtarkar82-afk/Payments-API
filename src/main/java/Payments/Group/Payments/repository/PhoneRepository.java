package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

}
