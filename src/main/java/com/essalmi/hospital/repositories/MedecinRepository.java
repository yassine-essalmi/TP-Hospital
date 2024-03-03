package com.essalmi.hospital.repositories;

import com.essalmi.hospital.entities.Medecin;
import com.essalmi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
