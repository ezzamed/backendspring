package org.sid.campagnevac.web;
import  org.sid.campagnevac.CampagneVacApplication;
import org.hibernate.bytecode.BytecodeLogger;
import org.slf4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class WebInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        BytecodeLogger.LOGGER.info("Entree de SpringApplicationBuilder configure(.)");

//        return super.configure(builder);
        return  builder.sources(CampagneVacApplication.class);
    }
}
