/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.config;

import cput.codez.angorora.handyApp.model.Converter;
import cput.codez.angorora.handyApp.services.Impl.ConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author allen
 */
@Configuration
public class ConverterConfig {
    @Bean(name="convert")
    public Converter getService(){
        return new ConverterImpl();
    }
}
