package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Processor_Response;

public interface Processor_ResponseRepository extends JpaRepository<Processor_Response, String> {

}
