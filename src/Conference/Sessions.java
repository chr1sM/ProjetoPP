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
    private int id, numPresentations, numParticipants, presentationDur;
    private LocalDateTime startSession;
    private String nameSession, theme;
    private Room room;
    private Presentation[] presentations;
    private Participant[] participants;

    public Sessions(String nameSession, String theme, Room room, LocalDateTime startSession) {
        setId(++idCount);
        this.startSession = startSession;
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

    private LocalDateTime endSession() {
        int temp = 0;

        for (int i = 0; i < numPresentations; i++) {
            temp = temp + this.presentations[i].getDuration();
        }

        LocalDateTime endSession = startSession.plusMinutes(temp + 10);

        return endSession;
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
        int temp = 0, duration = 0;

        for (int i = 0; i < numPresentations; i++) {
            temp = temp + this.presentations[i].getDuration();
        }

        LocalDateTime endSession = startSession.plusMinutes(temp);

        Duration dur = Duration.between(startSession, endSession);

        int total = (int) (dur.toSecondsPart() / 60);

        duration = total + temp + 10;

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

        if (i > this.numPresentations) {
            //execeção
        }

        for (int pos = 0; pos < this.numPresentations - 1; pos++) {
            if (this.presentations[pos].getId() == i) {
                this.presentations[pos] = this.presentations[pos + 1];
            }
        }
        this.presentations[--this.numPresentations] = null;

    }

    @Override
    public Presentation getPresentation(int i) throws SessionException {
        return this.presentations[i - 1];
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

    @Override
    public String toString() {
        String s = "";
        for (Presentation i : presentations) {
            if (i != null) {
                s += i.toString();
            }
        }
        return "\n\tSessao " + this.getId() + ": " + this.getSessionTheme() + " (Sala " + room.getId() + ": " + this.getStartTime().toLocalTime() + " - " + this.endSession().toLocalTime() + ")" + s;
    }
}
