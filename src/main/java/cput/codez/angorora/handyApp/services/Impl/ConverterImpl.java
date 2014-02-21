/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.services.Impl;

import cput.codez.angorora.handyApp.model.Converter;

/**
 *
 * @author allen
 */
public class ConverterImpl implements Converter {

    public double kiloToMile(double kilos) {
        return (kilos * 0.62137);
    }
}
