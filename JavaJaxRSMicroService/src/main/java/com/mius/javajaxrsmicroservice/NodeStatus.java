/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mius.javajaxrsmicroservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author lanakalashnyk
 */
public class NodeStatus {

    // Private Class Variables
    private String nodeStatusJSON;
    

    // Getters && Setters
    public String getNodeStatusJSON()
    {
        return nodeStatusJSON;        
            
    }
    
    public void setNodeStatusJSON(String status)
    {
        if(status.length()>0)
        {
            nodeStatusJSON = status;
        }
    }
    
    
    // Constructors
    NodeStatus()
    {
        nodeStatusJSON = "No Status Returned";
    }
    

    // Class Methods
    public boolean callBitCoinNodeForStatus() throws IOException {
        
        // TO DO : pass the URL and log in credentials from the React page
        
        URL url = new URL("http://000.000.000.000:6332");
        String requestJSON = ReadNodeInforRequestFile();
        
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        
        // TO DO Log this and the response from the WS
        System.out.println("Calling the bitcoin node");
        
        // set RPC User Login Info
        
        String rpcLogin = "bitcoinrpc:ooooooo";
        String encoding = new sun.misc.BASE64Encoder().encode (rpcLogin.getBytes());
        conn.setRequestProperty ("Authorization", "Basic " + encoding);
        //conn.setReadTimeout(10000);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write(requestJSON);
        writer.flush();
        String line ;
        StringBuilder nodeStatusSB = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
          nodeStatusSB.append(line);
          // TO DO Log this and the response from the WS
          System.out.println(line); 
        }
        setNodeStatusJSON(nodeStatusSB.toString());
        writer.close();
        reader.close();
        
       
        return true;
}
    
    private String ReadNodeInforRequestFile()
    {
                
        //Road Node Info Request Text 
        // TO DO send a JSON object instead of text
        StringBuilder requestString = new StringBuilder();
        try
        {
            String readLine = "N";
            BufferedReader fileReader = new BufferedReader(new FileReader("NodeInfoRequest.json")); 
            while((readLine = fileReader.readLine()) != null){
                requestString.append(readLine);
                System.out.println(readLine);
            }
             
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
        return requestString.toString();
    }
}
