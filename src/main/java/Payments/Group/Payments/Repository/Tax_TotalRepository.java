package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Tax_Total;

public interface Tax_TotalRepository extends JpaRepository<Tax_Total, UUID> {

}
