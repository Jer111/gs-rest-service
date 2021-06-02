package com.example.restservice;

import java.util.*;




public class RhythmGroup {
    

   
    private String rhythmname;
    
    private String rhythm;
    
    private List<User> userlist = new ArrayList<>();

    public RhythmGroup(){
        
    }

    public RhythmGroup (String rhythmname, String rhythm){
        this.rhythmname = rhythmname;
        this.rhythm = rhythm;
    }

    public String getRhythmName(){
        return rhythmname;
    }

    public String getRhythm(){
        return rhythm;
    }

    public void addUser(User user){
        userlist.add(user);
    }

    public List<User> getUsers(){
        return userlist;
    }
}