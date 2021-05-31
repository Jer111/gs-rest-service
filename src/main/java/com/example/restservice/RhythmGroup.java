package com.example.restservice;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class RhythmGroup {
    

    @Column(name = "rhythmname")
    private String rhythmname;
    @Column(name = "rhythm")
    private String rhythm;
    @Column(name = "userlist")
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