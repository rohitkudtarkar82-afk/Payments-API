package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Status_Details;

public interface Status_DetailsRepository extends JpaRepository<Status_Details, UUID> {

}
