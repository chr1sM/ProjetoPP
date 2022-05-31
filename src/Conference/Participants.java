/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import Enumeration.CheckIn;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;

/**
 *
 * @author Christopher
 */
public abstract class Participants implements Participant {

    private static int idCount = 0;
    private int id;
    private String nameParticipants, bio;
    private CheckIn checkIn;

    public Participants(String nameParticipants, String bio) {
        setId(++idCount);
        this.nameParticipants = nameParticipants;
        this.bio = bio;
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
        return nameParticipants;
    }

    @Override
    public String getBio() {
        return bio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Participants)) {
            return false;
        }
        final Participants other = (Participants) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Participants:\n" + "ID: " + id + ", Participant Name: " + nameParticipants + ", Bio: " + bio;
    }
}
