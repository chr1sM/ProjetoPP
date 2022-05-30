/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;

/**
 *
 * @author Christopher
 */
public class Participants extends Sessions implements Participant {

    private static int idCount = 0;
    private int id;
    private String name, bio;

    public Participants(String name, String bio) {
        setId(++idCount);
        this.name = name;
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
        return name;
    }

    @Override
    public String getBio() {
        return bio;
    }
}
