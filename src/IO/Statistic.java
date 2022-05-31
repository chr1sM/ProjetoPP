/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IO;

import estg.ipp.pt.tp02_conferencesystem.io.interfaces.Statistics;

/**
 *
 * @author Christopher
 */
public class Statistic implements Statistics {

    @Override
    public String getDescription() {
        return "A media e: " + getValue();
    }

    @Override
    public double getValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
