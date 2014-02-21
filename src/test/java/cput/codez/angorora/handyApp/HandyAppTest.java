/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp;


import cput.codez.angorora.handyApp.config.ConverterConfig;
import cput.codez.angorora.handyApp.model.Converter;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author allen
 */
public class HandyAppTest {
    public static Converter conv;
    public HandyAppTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void kiloTest() {
        System.out.println("****MILEKILLER APP*****\n");
       
       double kilos = Double.parseDouble(JOptionPane.showInputDialog("Enter distance in Kilometres"));
       double miles = kilos*0.62137;
       Assert.assertEquals(conv.kiloToMile(kilos), miles,0.00000001, "was calculated as a result"); 
        JOptionPane.showMessageDialog(null,conv.kiloToMile(kilos)+" Miles");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConverterConfig.class);
        conv=(Converter)context.getBean("convert");
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