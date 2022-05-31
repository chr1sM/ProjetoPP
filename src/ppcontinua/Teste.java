/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppcontinua;

import Conference.Aluno;
import Conference.Conferences;
import Conference.Presentations;
import Conference.Professor;
import Conference.Rooms;
import Conference.Sessions;
import Enumeration.GrauEscolaridade;
import estg.ipp.pt.tp02_conferencesystem.enumerations.ConferenceState;
import estg.ipp.pt.tp02_conferencesystem.exceptions.ConferenceException;
import estg.ipp.pt.tp02_conferencesystem.exceptions.SessionException;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Conference;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Presentation;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Room;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Session;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Christopher
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SessionException, ConferenceException {
        Room r1 = new Rooms(50, "Sala 1");
        
        Participant p1 = new Aluno("LSIRC", "21/22", "Chris", "Top player");
        Participant p2 = new Professor("Hacking", "Ze", "Cranio", GrauEscolaridade.Superior);
        
        Presentation present1 = new Presentations(20, "Ciberseguranca", p1);
        Presentation present2 = new Presentations(20, "Ciberseguranca2", p1);;
        Presentation present3 = new Presentations(20, "Ciberseguranca3", p1);;
        Presentation present4 = new Presentations(20, "Ciberseguranca4", p1);;
        
        Session s1 = new Sessions("Informatica", "Hacking", r1, LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 30)));
        Session s2 = new Sessions("Informatica", "IoT", r1, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 30)));
        
        //System.out.println(s1.getStartTime());
        
        s1.addPresentation(present1);
        s1.addPresentation(present4);
        s1.addPresentation(present3);
        
        s2.addPresentation(present2);
        
        //System.out.println("Duration: " + s1.getDuration() + " min");
        
        s1.removePresentation(4);
        
        //System.out.println(s1);
        
        Conference c1 = new Conferences("Teste", "Tecnologia", 2022);
        
        c1.addSession(s1);
        c1.addSession(s2);
        
        System.out.println(c1.getSchedule());
        
        
    }
}
