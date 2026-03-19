package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Schema;

public interface SchemaRepository extends JpaRepository<Schema, UUID> {

}
