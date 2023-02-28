package org.example;

import org.example.model.Appointment;
import org.example.service.AppointmentService;

public class Main {
    public static void main(String[] args) {
        Appointment appointment = new Appointment("Ann", "GP", "Head pain", 15, 02, 2023, 13, 25);

        AppointmentService as = new AppointmentService();


    }
}