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
import estg.ipp.pt.tp02_conferencesystem.interfaces.Conference;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Presentation;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Room;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Session;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Christopher
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_TIME;
        
        Room r1 = new Rooms(50, "Sala 1");
        
        Participant p1 = new Aluno("LSIRC", "21/22", "Chris", "Top player");
        Participant p2 = new Professor("Hacking", "Ze", "Cranio", GrauEscolaridade.Superior);
        
        Presentation present1 = new Presentations(20, "Ciberseguranca", p1);;
        
        Session s1 = new Sessions(LocalDateTime.parse("14:00", dtf), "Informatica", "Hacking", r1);
        
        Conference c1 = new Conferences("Teste", "Tecnologia", ConferenceState.ON_EDITING, 2022, s1, r1);
        
        
    }

}
