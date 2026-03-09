package Payments.Group.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Preferences;

public interface PreferencesRepository extends JpaRepository<Preferences, String> {

}
