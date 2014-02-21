/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.model;

/**
 *
 * @author allen
 */
public interface ProgressApp {

    public GymMember createObject(String name, String lastName, String phoneNum, double weight, double height, int yearOfBirth, String gymNUm);

    public int calculateAge(int yearOfBirth);

    public GymMember retrieveMemberDetail(GymMember memb, GymMember[] memberBase);

    public boolean progressCheck(double curWeight, double formerWeight);

    public GymMember[] createBackup(GymMember[] memberBase);
}
