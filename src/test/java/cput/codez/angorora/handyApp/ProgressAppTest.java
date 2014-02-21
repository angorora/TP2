/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp;

import cput.codez.angorora.handyApp.config.ProgressAppConfig;
import cput.codez.angorora.handyApp.model.GymMember;
import cput.codez.angorora.handyApp.model.ProgressApp;
import cput.codez.angorora.handyApp.services.Impl.ProgressAppImpl;
import java.util.Calendar;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author allen
 */
public class ProgressAppTest {

    public static ProgressApp progApp;
    public static GymMember member;
    public static GymMember memberBase[] = {new GymMember("Allen", "Ngorora", "0840472266", 70, 1.7, 1991, "J6476"), new GymMember("Bryane", "Ngorora", "073471146", 60, 1.8, 1991, "J6576")};
    public static Calendar cal;
    public static String name;
    public static String lastName;
    public static String phoneNum;
    public int yearOfBirth;
    public static double weight;
    public static double height;
    public String gymNum;

    public ProgressAppTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void identity() throws Exception {
        System.out.println("Running identity and exception tests.......");
        name = "Allen";
        lastName = "Ngorora";
        phoneNum = " 0840472266";
        yearOfBirth = 1991;
        weight = 70;
        height = 1.7;
        gymNum = "J6476";
        member = progApp.createObject(name, lastName, phoneNum, weight, height, yearOfBirth, gymNum);
        memberBase[2] = member;
        Assert.assertSame(member, memberBase[2]);
    }

    @Test
    public void createMemberObeject() {
        System.out.println("Asserting not null.....");
        name = "Allen";
        lastName = "Ngorora";
        phoneNum = " 0840472266";
        yearOfBirth = 1991;
        weight = 70;
        height = 1.7;
        gymNum = "J6476";
        Assert.assertNotNull((GymMember) progApp.createObject(name, lastName, phoneNum, weight, height, yearOfBirth, gymNum));
    }

    @Test
    public void createBackup() {
        System.out.println("Asserting that arrays content is equal.......");
        GymMember cloneBase[] = progApp.createBackup(memberBase);
        Assert.assertEquals(cloneBase, memberBase);
    }

    @Test
    public void ageTest() {
        System.out.println("Doing integer assertions....");
        yearOfBirth = 1991;
        Calendar today = cal.getInstance();
        int thisyear = today.get(Calendar.YEAR);
        int age = thisyear - yearOfBirth;
        Assert.assertEquals(progApp.calculateAge(yearOfBirth), age);
    }

    @Test
    public void checkIn() {
        System.out.println("Asserting object equality.....");
        member = new GymMember("Allen", "Ngorora", "0840472266");
        Assert.assertEquals(member, progApp.retrieveMemberDetail(member, memberBase));
    }

    @Test
    public void negativeProgressCheck() {
        System.out.println("\nAsserting Truth.....\n");
        member = new GymMember("Allen", "Ngorora", "0840472266");
        System.out.println("\n" + progApp.retrieveMemberDetail(member, memberBase));
        double curWeight = 69;
        double formerWeight = progApp.retrieveMemberDetail(member, memberBase).getWeight();
        Assert.assertTrue(progApp.progressCheck(curWeight, formerWeight));
    }
    
   /* @Ignore("Its in the latest version")
    @Test
    public void bMICalc(){
        Assert.assertEquals(progApp.caculateBMI(weight,height), 24, 0.001);
    }*/
    @Test(timeOut = 0)
    public void positiveProgressCheck() {
        System.out.println("\nAsseting Falsity....\n");
        member = new GymMember("Allen", "Ngorora", "0840472266");
        System.out.println("\n" + progApp.retrieveMemberDetail(member, memberBase));
        double curWeight = 71;
        double formerWeight = progApp.retrieveMemberDetail(member, memberBase).getWeight();
        height = 1.71;
        Assert.assertFalse(progApp.progressCheck(curWeight, formerWeight));
        ProgressAppImpl impl = new ProgressAppImpl();
        impl.adviceMember(curWeight, formerWeight);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProgressAppConfig.class);
        progApp = (ProgressApp) context.getBean("progress");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}