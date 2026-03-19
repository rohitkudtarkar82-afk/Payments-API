package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Item_Total;

public interface Item_TotalRepository extends JpaRepository<Item_Total, UUID> {

}
