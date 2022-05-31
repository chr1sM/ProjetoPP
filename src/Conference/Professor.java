/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conference;

import Enumeration.GrauEscolaridade;

/**
 *
 * @author Christopher
 */
public class Professor extends Participants{

    private String expert;
    private GrauEscolaridade grau;

    public Professor(String expert, String nameParticipants, String bio, GrauEscolaridade grau) {
        super(nameParticipants, bio);
        this.grau = grau;
        this.expert = expert;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public GrauEscolaridade getGrau() {
        return grau;
    }

    public void setGrau(GrauEscolaridade grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return super.toString() + "Professor:\n" + "Expert: " + expert + ", Grau: " + grau;
    }
}
