/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import estg.ipp.pt.tp02_conferencesystem.enumerations.ConferenceState;
import estg.ipp.pt.tp02_conferencesystem.exceptions.ConferenceException;
import estg.ipp.pt.tp02_conferencesystem.exceptions.SessionException;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Conference;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Room;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Session;
import estg.ipp.pt.tp02_conferencesystem.io.interfaces.Statistics;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher
 */
public class Conferences implements Conference {

    private static final int MAXsession = 5;
    private String conferenceName, field;
    private ConferenceState conferenceState;
    private int year, numParticipants, numSession;
    private Session[] sessions;
    private Participant[] participants;

    public Conferences(String conferenceName, String field, int year) {
        this.conferenceName = conferenceName;
        this.field = field;
        this.conferenceState = ConferenceState.ON_EDITING;
        this.year = year;
        this.sessions = new Session[MAXsession];
    }

    private int findSession(Session sn) {
        int pos = -1;

        for (int i = 0; i < numSession; i++) {
            if (this.sessions[i].getSessionTheme().equals(sn.getSessionTheme())) {
                pos = i;
            }
        }
        return pos;
    }

    private int findParticipant(Participant parti) {
        int pos = -1;

        for (int i = 0; i < numParticipants; i++) {
            if (this.participants[i].getId() == parti.getId()) {
                pos = i;
            }
        }
        return pos;
    }

    @Override
    public String getName() {
        return conferenceName;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public ConferenceState getState() {
        return conferenceState;
    }

    @Override
    public void changeState() {
        if (conferenceState == ConferenceState.ON_EDITING) {
            conferenceState = ConferenceState.IN_PROGRESS;
        } else {
            conferenceState = ConferenceState.FINISHED;
        }
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean addSession(Session sn) throws ConferenceException {
        int pos = findSession(sn);

        if (sn == null) {
            return false;
        }
        if (numSession == this.sessions.length) {
            return false;
        }
        if (pos != -1) {
            return false;
        }

        this.sessions[numSession++] = sn;
        return true;
    }

    @Override
    public void removeSession(int i) throws ConferenceException {
        if (i > this.numSession) {
            //execeção
        }

        for (int pos = 0; pos < this.numSession - 1; pos++) {
            if (this.sessions[pos].getId() == i) {
                this.sessions[pos] = this.sessions[pos + 1];
            }
        }
        this.sessions[--this.numSession] = null;
    }

    @Override
    public Session getSession(int i) throws ConferenceException {
        return this.sessions[i - 1];
    }

    @Override
    public Session[] getSessions() {
        int total = 0, countSessions = 0;
        for (int i = 0; i < numSession; i++) {
            if (this.sessions[i] instanceof Session) {
                total++;
            }
        }
        Session[] temp = new Session[total];
        for (int i = 0; i < numSession; i++) {
            if (this.sessions[i] instanceof Session) {
                temp[countSessions++] = this.sessions[i];
            }
        }
        return temp;
    }

    @Override
    public void checkIn(Participant p) throws ConferenceException {
        int pos = findParticipant(p);

        if (p == null) {
            //execao
        }
        if (pos != -1) {
            //execao
        }
        if (conferenceState == ConferenceState.IN_PROGRESS) {
            this.participants[numParticipants++] = p;
        } else {
            //execao
        }
    }

    @Override
    public Participant getParticipant(int i) throws ConferenceException {
        return this.participants[i - 1];
    }

    @Override
    public Participant[] getParticipants() {
        int total = 0, countParticipants = 0;
        for (int i = 0; i < numParticipants; i++) {
            if (this.participants[i] instanceof Participant) {
                total++;
            }
        }
        Participant[] temp = new Participant[total];
        for (int i = 0; i < numParticipants; i++) {
            if (this.participants[i] instanceof Participant) {
                temp[countParticipants++] = this.participants[i];
            }
        }
        return temp;
    }

    @Override
    public Participant[] getSpeakerParticipants() {
        Participant[] temp =  new Participant[numParticipants];
        int count = 0;
        
        for (int i = 0; i < numParticipants; i++) {
            try {
                if (this.sessions[i].getPresentation(i).getPresenter().getId() == this.participants[i].getId()) {
                    temp[count++] = this.participants[i];
                }
            } catch (SessionException ex) {
                System.out.println(ex);
            }
        }
        return temp;
    }

    @Override
    public Session[] getRoomSessions(int i, LocalDateTime ldt, LocalDateTime ldt1) throws ConferenceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Room[] getRooms() {
        Room[] temp = new Room[numSession];

        for (int i = 0; i < numSession; i++) {
            if (!(this.sessions[i].getRoom().getId() == temp[i].getId())) {
                temp[i] = this.sessions[i].getRoom();
            }
        }
        return temp;
    }

    @Override
    public void generateSpeakerCertificates(String string) throws ConferenceException {
//Fazer com export
    }

    @Override
    public void generateParticipantCertificates(String string) throws ConferenceException {
//Fazer com export
    }

    @Override
    public String getSchedule() {
        return toString();
    }

    @Override
    public Statistics[] getNumberOfParticipantsBySession() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Statistics[] getNumberOfSessionsByRoom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        String s = "";
        for (Session i : sessions) {
            if (i != null) {
                s += i.toString();
            }
        }
        return "Conferencia " + conferenceName + ": Tema - " + field + s;
    }

}
