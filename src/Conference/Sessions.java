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
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Christopher
 */
public class Sessions implements Session {

    private static int idCount = 0;
    private static final int MAX = 5;
    private final int maxDurPresentation = 30;
    private int id, numPresentations, numParticipants, presentationDur;
    private LocalDateTime startSession;
    private String nameSession, theme;
    private Room room;
    private Presentation[] presentations;
    private Participant[] participants;

    public Sessions(LocalDateTime String, String nameSession, String theme, Room room) {
        setId(++idCount);
        this.presentationDur = maxDurPresentation;
        this.startSession = String;
        this.nameSession = nameSession;
        this.theme = theme;
        this.room = room;
        this.presentations = new Presentation[MAX];
        this.participants = new Participant[this.room.getNumberOfSeats()];
    }

    private void setId(int id) {
        this.id = id;
    }

    private int findPresentation(Presentation prsntn) {
        int pos = -1;

        for (int i = 0; i < numPresentations; i++) {
            if (this.presentations[i].getTitle().equals(prsntn.getTitle())) {
                pos = i;
            }
        }
        return pos;
    }

    private Presentation[] expandArray() {
        Presentation[] tempArray = new Presentation[this.presentations.length * 2];

        for (int i = 0; i < this.presentations.length; i++) {
            tempArray[i] = this.presentations[i];
        }

        return tempArray;
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
        LocalDateTime endSession = startSession.plusHours(2);

        Duration dur = Duration.between(startSession, endSession);

        int duration = (int) (dur.getSeconds() / 60);

        return duration;
    }

    @Override
    public int getMaxDurationPerPresentation() {
        return presentationDur;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startSession;
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
        int pos = findPresentation(prsntn);

        if (prsntn == null) {
            return false;
        }
        if (numPresentations == this.presentations.length) {
            presentations = expandArray();
        }
        if (pos != -1) {
            return false;
        }

        this.presentations[numPresentations++] = prsntn;
        return true;
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
            if (this.presentations[i] instanceof Presentation) {
                total++;
            }
        }
        Presentation[] temp = new Presentation[total];
        for (int i = 0; i < numPresentations; i++) {
            if (this.presentations[i] instanceof Presentation) {
                temp[countPresentations++] = this.presentations[i];
            }
        }
        return temp;
    }

    @Override
    public boolean isStarted() {
        if (this.getPresentations().equals(PresentationState.NOT_PRESENTED) || this.getPresentations().equals(PresentationState.PRESENTED)) {
            return true;
        }
        return false;
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
