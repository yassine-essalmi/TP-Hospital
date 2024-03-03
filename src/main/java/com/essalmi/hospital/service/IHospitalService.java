package com.essalmi.hospital.service;

import com.essalmi.hospital.entities.Consultation;
import com.essalmi.hospital.entities.Medecin;
import com.essalmi.hospital.entities.Patient;
import com.essalmi.hospital.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
