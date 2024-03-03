package com.essalmi.hospital;

import com.essalmi.hospital.entities.*;
import com.essalmi.hospital.repositories.ConsultationRepository;
import com.essalmi.hospital.repositories.MedecinRepository;
import com.essalmi.hospital.repositories.PatientRepository;
import com.essalmi.hospital.repositories.RendezVousRepository;
import com.essalmi.hospital.service.HospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(HospitalServiceImpl hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("amine", "rihab", "hajar").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setSpecialite(Math.random() > 0.5 ? "dentiste" : "pediatre");
                medecin.setEmail(name + "@gmail.com");
                hospitalService.saveMedecin(medecin);
            });

            Stream.of("hamid", "yassine", "mohamed").forEach(name -> {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(true);
                hospitalService.savePatient(patient);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Medecin medecin = medecinRepository.findById(1L).orElse(null);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.DONE);
            hospitalService.saveRendezVous(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setRendezVous(rendezVous);
            consultation.setDateConsultation(rendezVous.getDate());
            consultation.setRapport("consultation de " + patient.getName());
            hospitalService.saveConsultation(consultation);

        };
    }
}
