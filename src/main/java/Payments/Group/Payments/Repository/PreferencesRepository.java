package Payments.Group.Payments.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Payments.Group.Payments.Entity.Preferences;

public interface PreferencesRepository extends JpaRepository<Preferences, UUID> {

    void save(java.util.prefs.Preferences preferences);
    

}
