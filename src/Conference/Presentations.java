/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import estg.ipp.pt.tp02_conferencesystem.enumerations.PresentationState;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Participant;
import estg.ipp.pt.tp02_conferencesystem.interfaces.Presentation;

/**
 *
 * @author Christopher
 */
public class Presentations extends Participants implements Presentation {

    private static int idCount = 0;
    private int id, duration;
    private String title;
    private PresentationState presentationState;

    public Presentations(int id, int duration, String title, PresentationState presentationState, String name, String bio) {
        super(name, bio);
        setId(++idCount);
        this.duration = duration;
        this.title = title;
        this.presentationState = presentationState;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public PresentationState getPresentationState() {
        return presentationState;
    }

    @Override
    public void setPresented() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Participant getPresenter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
