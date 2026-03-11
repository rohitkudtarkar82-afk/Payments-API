package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Link;

public interface LinkRepository extends JpaRepository<Link, String> {

}
