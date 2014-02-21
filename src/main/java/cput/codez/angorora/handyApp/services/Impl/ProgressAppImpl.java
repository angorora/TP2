/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.services.Impl;

import cput.codez.angorora.handyApp.model.GymMember;
import cput.codez.angorora.handyApp.model.ProgressApp;
import java.util.Calendar;

/**
 *
 * @author allen
 */
public class ProgressAppImpl implements ProgressApp {

    public static Calendar cal;

    public GymMember createObject(String name, String lastname, String phoneNum, double weight, double height, int yearOfBirth, String gymNum) {
        return new GymMember(name, lastname, phoneNum, weight, height, yearOfBirth, gymNum);
    }

    public int calculateAge(int yearOfBirth) {
        Calendar today = cal.getInstance();
        int thisYear = today.get(Calendar.YEAR);
        return (thisYear - yearOfBirth);
    }

    public GymMember retrieveMemberDetail(GymMember memb, GymMember[] memberBase) {
        boolean found = false;
        GymMember databaseExtract = null;
        for (GymMember m : memberBase) {
            if (memb.equals(m)) {
                found = true;
                databaseExtract = m;
            }
        }
        return databaseExtract;
    }

    public boolean progressCheck(double curWeight, double formerWeight) {
        return (formerWeight > curWeight);
    }

    public void adviceMember(double curWeight, double formerWeight) {
        //  progressCheck(curWeight,formerWeight)? System.out.println("yes"): System.out.println("No");        
        System.out.println((progressCheck(curWeight, formerWeight)) ? "\nSo....you have gained weight since you started using ProgressApp" : "So....you have lost weight since you started using ProgressApp");
        System.out.println("\n/\\*****Make sure that if this is not your target you go and see your trainer and get advice****\n\n\n");
    }

    public GymMember[] createBackup(GymMember[] memberBase) {
        return (memberBase.clone());
    }
}