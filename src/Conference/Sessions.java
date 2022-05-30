/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import estg.ipp.pt.tp02_conferencesystem.enumerations.PresentationState;
import estg.ipp.pt.tp02_conferencesystem.exceptions.SessionException;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Presentation;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Room;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Session;
import java.time.LocalDateTime;

/**
 *
 * @author Christopher
 */
public class Sessions implements Session {

    private static int idCount = 0;
    private static final int MAX = 5;
    private int id, duration, maxDuration, numPresentations, numParticipants;
    private LocalDateTime localdate;
    private String nameSession, theme;
    private Rooms room;
    private Presentations[] presentations;
    private Participants[] participants;

    public Sessions(int duration, int maxDuration, int numPresentations, LocalDateTime localdate, String nameSession, String theme, Rooms room) {
        setId(++idCount);
        this.duration = duration;
        this.maxDuration = maxDuration;
        this.numPresentations = numPresentations;
        this.localdate = localdate;
        this.nameSession = nameSession;
        this.theme = theme;
        this.room = room;
        this.presentations = new Presentations[MAX];
        this.participants = new Participants[this.room.getNumberOfSeats()];
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return nameSession;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getMaxDurationPerPresentation() {
        return maxDuration;
    }

    @Override
    public LocalDateTime getStartTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSessionTheme() {
        return theme;
    }

    @Override
    public Room getRoom() {
        return room;
    }

    @Override
    public boolean addPresentation(Presentation prsntn) throws SessionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePresentation(int i) throws SessionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presentation getPresentation(int i) throws SessionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presentation[] getPresentations() {
        int total = 0, countPresentations = 0;
        for (int i = 0; i < numPresentations; i++) {
            if (this.presentations[i] instanceof Presentations) {
                total++;
            }
        }
        Presentations[] temp = new Presentations[total];
        for (int i = 0; i < numPresentations; i++) {
            if (this.presentations[i] instanceof Presentations) {
                temp[countPresentations++] = this.presentations[i];
            }
        }
        return temp;
    }

    @Override
    public boolean isStarted() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Participant[] getAllPresenters() {
        int total = 0, countParticipants = 0;
        for (int i = 0; i < numParticipants; i++) {
            if (this.presentations[i].getPresentationState().equals(PresentationState.NOT_PRESENTED) 
                    || this.presentations[i].getPresentationState().equals(PresentationState.PRESENTED)) {
                total++;
            }
        }
        Participant[] temp = new Participant[total];
        for (int i = 0; i < numParticipants; i++) {
                temp[countParticipants++] = this.participants[i];
        }
        return temp;
    }

    @Override
    public int getNumberOfPresentations() {
        return numPresentations;
    }

}
