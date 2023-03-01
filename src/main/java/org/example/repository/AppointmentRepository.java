package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Appointment;

import java.util.Optional;

public class AppointmentRepository {
    public void createAppointment(EntityManager em, Appointment appointment) {
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
    }

    public Optional<Appointment> readAppointment(EntityManager em, String id) {
        Appointment appointment = em.find(Appointment.class, id);
        return Optional.ofNullable(appointment);
    }

    public void deleteAppointment(EntityManager em, Appointment appointment) {
        em.getTransaction().begin();
        em.remove(appointment);
        em.getTransaction().commit();
    }
    public void updateAppointment(EntityManager em, Appointment appointment) {
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }






}
