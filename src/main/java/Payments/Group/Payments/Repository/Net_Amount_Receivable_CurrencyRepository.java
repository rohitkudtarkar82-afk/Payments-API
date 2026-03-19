package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Net_Amount_Receivable_Currency;

public interface Net_Amount_Receivable_CurrencyRepository
        extends JpaRepository<Net_Amount_Receivable_Currency, UUID> {

}
