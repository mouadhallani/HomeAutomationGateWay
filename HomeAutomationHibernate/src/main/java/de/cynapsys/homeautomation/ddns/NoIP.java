/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.ddns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;




public class NoIP extends Thread {


//    public static void main(String[] args) {
//        NoIP n = new NoIP("anisjribi@gmail.com","annous1992");
//        n.submitHostname("beity.ddns.net");
//    }
    
    private String username;
    private String password;
    //time in minutes
    private int updateTime = 1;
    
    public NoIP(String username,String password){
        this.username = username;
        this.password = password;
        this.start();
    }
    
    private List<String> hostnames = new LinkedList<String>();
    
    public void submitHostname(String hostname){
        synchronized(hostnames) {
            hostnames.add(hostname);
        }
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep((updateTime*60000));
                if(hostnames.size() <= 0)
                    continue;
                String IP = getCurrentIP();
                if(IP.equals("null"))
                    continue;
                synchronized(hostnames) {
                    for(String host : hostnames){
                        if(!submitIpUpdate(IP,host))
                            return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private String getCurrentIP(){
        String IP = "null";
        String host = "http://bot.whatismyipaddress.com";
        try {
            URL url = new URL(host);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestProperty("User-Agent","Java NoIP Updated 1.0");    
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            IP = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return IP;
    }
    
    private boolean submitIpUpdate(String newIP,String hostname){
        String host = "http://dynupdate.no-ip.com/nic/update?hostname="+hostname+"&myip="+newIP;
        try {
            URL url = new URL(host);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            String auth = new String (Base64.encodeBase64((username+":"+password).getBytes()));
            http.setRequestProperty("Authorization","Basic "+auth);    
            http.setRequestProperty("User-Agent","Java NoIP Updated 1.0");    
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("good")){
                    System.out.println("IP Update Successful: "+line.substring(5));
                    return true;
                } else if(line.startsWith("nochg")){
                    return true;
                } else if(line.startsWith("badauth")){
                    System.out.println("Invalid Login Details");
                } else if(line.startsWith("badagent")){
                    System.out.println("Bad user agent supplied");
                } else if(line.startsWith("abuse")){
                    System.out.println("Account hs been disabled");
                } else if(line.startsWith("911")){
                    System.out.println("Server fallover");
                } else if(line.startsWith("!donator")){
                    System.out.println("You cannot use donator features");
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }


}