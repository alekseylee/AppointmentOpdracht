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

    public Optional<Appointment> readAppointment(EntityManager em, String name) {
        Appointment appointment = em.find(Appointment.class, name);
        return Optional.ofNullable(appointment);
    }

    public void updateAppointment(EntityManager em, Appointment appointment) {
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }


    public void deleteAppointment(EntityManager em, String name) {
        em.getTransaction().begin();
        Appointment appointment = em.find(Appointment.class, name);
        em.remove(appointment);
        em.getTransaction().commit();
    }



}
