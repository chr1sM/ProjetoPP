/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import estg.ipp.pt.tp02_conferencesystem.interfaces.Room;

/**
 *
 * @author Christopher
 */
public class Rooms extends Conferences implements Room {

    private static int idCount = 0;
    private int id, numSeats;
    private String name;

    public Rooms(int numSeats, String name) {
        setId(++idCount);
        this.numSeats = numSeats;
        this.name = name;
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
    public int getNumberOfSeats() {
        return numSeats;
    }
}
