package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.connection.EntityManagerProvider;
import org.example.model.Appointment;
import org.example.repository.AppointmentRepository;

import java.util.Optional;

public class AppointmentService {
    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void createCountry(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.createAppointment(em, appointment);
        em.close();
    }

    public Optional<Appointment> readAppointment(String name) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> optionalAppointment = appointmentRepository.readAppointment(em, name);
        em.close();
        return optionalAppointment;
    }

    public void deleteCountry(String name){
        EntityManager em = EntityManagerProvider.getEntityManager();

        appointmentRepository.deleteAppointment(em, name);
        em.close();
    }

    public void updateCountry(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.updateAppointment(em, appointment);
        em.close();
    }

}
