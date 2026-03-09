package Payments.Group.Payments.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Related_Ids;

public interface Related_IdsRepository extends JpaRepository<Related_Ids, UUID> {

}
