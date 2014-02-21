/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.handyApp.config;

import cput.codez.angorora.handyApp.services.Impl.ProgressAppImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author allen
 */
@Configuration
public class ProgressAppConfig {

    @Bean(name = "progress")
    public ProgressAppImpl getService() {
        return new ProgressAppImpl();
    }
}
