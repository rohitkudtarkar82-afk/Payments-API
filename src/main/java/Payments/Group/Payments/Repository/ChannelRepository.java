package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.DTO.ChannelRequestDTO;
import Payments.Group.Payments.DTO.CustomerRequestDTO;
import Payments.Group.Payments.Entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, UUID> {

   

        void save(ChannelRequestDTO channelRequestDTO);
    
        void save(CustomerRequestDTO customerRequestDTO);


}
