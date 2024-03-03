package com.essalmi.hospital.repositories;

import com.essalmi.hospital.entities.Consultation;
import com.essalmi.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
