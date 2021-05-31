package com.example.restservice;


import org.springframework.data.repository.CrudRepository;
import java.util.*;  

public interface RhythmRepository extends CrudRepository{
    List findByRhythm(String rhythmname);
}