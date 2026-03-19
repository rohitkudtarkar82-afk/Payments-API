package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Links;

public interface LinksRepository extends JpaRepository<Links, UUID> {

}
