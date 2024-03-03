package com.essalmi.hospital.repositories;

import com.essalmi.hospital.entities.Patient;
import com.essalmi.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
