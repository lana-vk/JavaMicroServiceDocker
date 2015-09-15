/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mius.javajaxrsmicroservice;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author lanakalashnyk
 */
@Path("/NodeStatus")
public class BitCoinNode {
    
    @GET
    @Produces({ MediaType.TEXT_PLAIN }) // TO DO make this a JSON Response
    public Response getNodeStatus(){
        
       NodeStatus homeNodeStatus = new NodeStatus();
       try
       {
       // unless a status is retrieved report a server error
        if (homeNodeStatus.callBitCoinNodeForStatus() == true)
        {
            System.out.println(homeNodeStatus.getNodeStatusJSON());
             return Response.ok(homeNodeStatus.getNodeStatusJSON(), MediaType.TEXT_PLAIN).build();
        }
        else
        {
            return Response.serverError().build();

        }
       }
       catch(IOException e)
       {
           Response.serverError().build();
       
       }
return null;
    }
}
