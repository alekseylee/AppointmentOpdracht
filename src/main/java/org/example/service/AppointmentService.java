package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.connection.EntityManagerProvider;
import org.example.model.Appointment;
import org.example.repository.AppointmentRepository;

import java.util.Optional;

public class AppointmentService {
    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void createAppointment(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.createAppointment(em, appointment);
        em.close();
    }

    public Optional<Appointment> readAppointment(String id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> optionalAppointment = appointmentRepository.readAppointment(em, id);
        em.close();
        return optionalAppointment;
    }

    public void deleteAppointment(String id){
        EntityManager em = EntityManagerProvider.getEntityManager();

        appointmentRepository.deleteAppointment(em, id);
        em.close();
    }

    public void updateAppointment(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentRepository.updateAppointment(em, appointment);
        em.close();
    }


}
