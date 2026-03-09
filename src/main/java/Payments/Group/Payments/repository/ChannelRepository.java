package Payments.Group.Payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, String> {

}
