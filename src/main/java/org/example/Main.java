package org.example;

import org.example.model.Appointment;
import org.example.service.AppointmentService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Appointment client1 = new Appointment( "GP", "Head pain", 28, 02, 2023, 13, 25);
        Appointment client2 = new Appointment( "Hand Surgery", "Break hand", 28, 02, 2023, 10, 01);
        Appointment client3 = new Appointment( "Dentist", "Veneers Procedure", 01, 03, 2023, 9, 44);
        Appointment client4 = new Appointment( "Ophthalmologist", "Vision test", 05, 01, 2023, 8, 25);

        AppointmentService as = new AppointmentService();

        // Create new appointments
        as.createAppointment(client1);
        as.createAppointment(client2);
        as.createAppointment(client3);
        as.createAppointment(client4);

        // Read appointments
        Optional<Appointment> dbAppointment = as.readAppointment("1_3_2023__9_44");
        if (dbAppointment.isPresent()) {
            System.out.println(dbAppointment.get());
        } else {
            System.out.println("No Appointment found!");
        }

//         Delete appointments
        as.deleteAppointment("1_3_2023__9_44");

//
//        // Update appointments
        Optional<Appointment> appointmentToUpdate = as.readAppointment("28_2_2023__10_1");
        if (appointmentToUpdate.isPresent()) {
            Appointment foundAppointment = appointmentToUpdate.get();
            foundAppointment.setHour(foundAppointment.getHour()+1);
            as.updateAppointment(foundAppointment);
        }

    }
}