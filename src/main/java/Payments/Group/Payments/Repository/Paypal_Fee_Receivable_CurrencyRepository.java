package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Paypal_Fee_Receivable_Currency;

public interface Paypal_Fee_Receivable_CurrencyRepository
        extends JpaRepository<Paypal_Fee_Receivable_Currency, UUID> {

}
