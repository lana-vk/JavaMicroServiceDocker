/*
 * Main is the entry point to the SWARM 
 * container. If additional mods to the Swarm container 
 * necessary, 
 * do them here ( strip / add functionality).
 */
package com.mius.javajaxrsmicroservice;

import lombok.extern.slf4j.Slf4j;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;

/**
 *
 * @author lanakalashnyk
 */

@Slf4j
public class JaxRSServriceSwarmMain {
    public static void main(String[] args) throws Exception {
        
        // this is a WildFly Swarm Container
        Container container = new Container();
        String logLevel = "INFO";
        container.fraction(new LoggingFraction()
                .formatter("PATTERN", "%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c] (%t) %s%e%n")
                .consoleHandler(logLevel, "PATTERN")
                .rootLogger(logLevel, "CONSOLE"));
        container.start();
        
        JAXRSArchive jaxrsDeployment = ShrinkWrap.create(JAXRSArchive.class);
        jaxrsDeployment.addClass(JaxRSService.class);
        jaxrsDeployment.addResource(BitCoinNode.class);
        jaxrsDeployment.addResource(NodeStatus.class);
        container.deploy(jaxrsDeployment);
    }
    
}
