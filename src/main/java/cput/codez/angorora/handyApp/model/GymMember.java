/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.model;

/**
 *
 * @author allen
 */
public class GymMember {

    private String name;
    private String lastname;
    private String phoneNum;
    private double weight;
    private double height;
    private String gymNum;
    private int yearOfBirth;

    public GymMember(String name, String lastname, String phoneNum, double weight, double height, int yearOfBirth, String gymNum) {
        this.name = name;
        this.lastname = lastname;
        this.phoneNum = phoneNum;
        this.weight = weight;
        this.height = height;
        this.yearOfBirth = yearOfBirth;
        this.gymNum = gymNum;
    }

    public GymMember(String name, String lastname, String phoneNum) {
        this.name = name;
        this.lastname = lastname;
        this.phoneNum = phoneNum;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGymNum(String gymNum) {
        this.gymNum = gymNum;
    }

    public String getGymNum() {
        return gymNum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.phoneNum != null ? this.phoneNum.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "GymMember Name:   " + name + "\nLastname:   " + lastname + "\nPhone Number:   " + phoneNum + "\nWeight:   " + weight + "\nHeight:   " + height + "\nGym Number:  " + gymNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GymMember other = (GymMember) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.lastname == null) ? (other.lastname != null) : !this.lastname.equals(other.lastname)) {
            return false;
        }
        if ((this.phoneNum == null) ? (other.phoneNum != null) : !this.phoneNum.equals(other.phoneNum)) {
            return false;
        }
        return true;
    }
}
