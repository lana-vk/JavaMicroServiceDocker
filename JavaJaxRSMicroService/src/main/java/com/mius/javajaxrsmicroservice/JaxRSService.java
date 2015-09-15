/*
 * Add classes to our JaxRSService 
 */
package com.mius.javajaxrsmicroservice;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author lanakalashnyk Mius LLC
 */

@ApplicationScoped
@ApplicationPath("/")
public class JaxRSService extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(BitCoinNode.class);
        classes.add(NodeStatus.class);
        return classes;
    
    }
    
}
