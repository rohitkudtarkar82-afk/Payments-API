package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Payment_Instruction;

public interface Payment_InstructionRepository extends JpaRepository<Payment_Instruction, UUID> {

}
