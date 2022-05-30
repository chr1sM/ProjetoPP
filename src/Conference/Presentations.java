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
public class Presentations implements Presentation {

    private static int idCount = 0;
    private int id, presentDuration;
    private String title;
    private PresentationState presentationState;
    private Participants participants;

    public Presentations(int presentDuration, String title, PresentationState presentationState, Participants participants) {
        setId(++idCount);
        this.presentDuration = presentDuration;
        this.title = title;
        this.presentationState = presentationState;
        this.participants = participants;
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
        return presentDuration;
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
        return participants;
    }

}
