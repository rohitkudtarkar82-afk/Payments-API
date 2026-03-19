package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Media;

public interface MediaRepository extends JpaRepository<Media, UUID> {

}
