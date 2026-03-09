package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payment_Source_Constraint;

public interface Payment_Source_ConstraintRepository extends JpaRepository<Payment_Source_Constraint, String> {

}
