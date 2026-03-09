package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, String> {

}
