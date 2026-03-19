package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Target_Schema;

public interface Target_SchemaRepository extends JpaRepository<Target_Schema, UUID> {

}
