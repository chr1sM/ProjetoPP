/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppcontinua;

import Conference.Participants;
import Conference.Presentations;
import Conference.Rooms;
import Conference.Sessions;
import estg.ipp.pt.tp02_conferencesystem.enumerations.PresentationState;
import java.time.LocalDateTime;



/**
 *
 * @author Christopher
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rooms r1 = new Rooms(50, "Sala 1");
        Participants p1 = new Participants("Chris", "Aluno");
        Presentations present1 =  new Presentations(20, "Ciberseguranca", PresentationState.NOT_PRESENTED, p1);
        Sessions s1 = new Sessions(20, 30, 5, LocalDateTime.now(), "Ciberseguranca", "Informatica", r1);
    }
    
}
