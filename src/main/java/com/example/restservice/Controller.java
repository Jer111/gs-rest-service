package com.example.restservice;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	RhythmRepository repository;

	private List<RhythmGroup> grouplist = new ArrayList<>();

	public void print() {
		for (RhythmGroup track : grouplist) {
			System.out.printf("Track: %s, rhythm: %s, users:\n", track.getRhythmName(), track.getRhythm());
			for (User u : track.getUsers()) {
				System.out.println(u.getName() + " " + u.getScore());
			}
		}
		System.out.println("-------------------------------------------------------------------");
	}

	/*
	 * The following function takes an http request and put the name and score of
	 * the person in the dedicated group
	 */
	@GetMapping("/user")
	public User user(@RequestParam(value = "group", defaultValue = "") String group,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "score", defaultValue = "0") String score) {
		User user = new User(name, Integer.parseInt(score));
		// çheck if group is in the list with groups.
		for (RhythmGroup track : grouplist) {
			if (group.equals(track.getRhythmName())) {
				boolean exists = false;
				for (User u : track.getUsers()) {// check if their is not a duplicate user.
					if (name.equals(u.getName())) {
						exists = true;
						break;
					}
				}
				if (!exists) {
					repository.save(user);
					track.addUser(user);// if there is not a duplicate add the user.
				} else {
					for (User u : track.getUsers()) { // else replace the score if higher.
						if (name.equals(u.getName())) {
							if (u.getScore() < Integer.parseInt(score)){
								u.setScore(Integer.parseInt(score));
							}
							
						}
					}
					break;
				}
			}
		}
		print();
		return user;
	}

	/*The following function takes a http request and makes a group out of that. */
	@GetMapping("/group")
	public RhythmGroup rhythmGroup(@RequestParam(value = "rhythmname", defaultValue = "") String rhythmname,
			@RequestParam(value = "rhythm", defaultValue = "") String rhythm) {

		RhythmGroup mygroup = new RhythmGroup(rhythmname, rhythm);
		boolean exists = false;
		//check if the group already exists
		for (RhythmGroup track : grouplist) {
			if (rhythmname.equals(track.getRhythmName())) {
				exists = true;
				break;
			}
		}
		if (!exists) { //if it not exists: add to the list.
			grouplist.add(mygroup);
		}
		print();
		return mygroup;
	}
	/* The following function takes a http request with a group name in it, and returns the scoreboard of that group in the body.*/
	@GetMapping("/scoreboard")
	public Scoreboard scoreboard(@RequestParam(value = "rhythmname") String rhythmname) {
		Scoreboard name = new Scoreboard();
		//check if the group exists
		for (RhythmGroup track : grouplist) {
			System.err.println(track.getRhythmName() + rhythmname);
			if (track.getRhythmName().equals(rhythmname)) {
				name = new Scoreboard(track); //make a scoreboard for that group.
				break;
			}
			
		}

		return name;

	}

	//This function takes a grouprhythm and return the rhythm in the body.
	@GetMapping("/rhythm")
	public String getrhythm(@RequestParam(value = "group") String group){
		for (RhythmGroup track :grouplist){
			if (track.getRhythmName().equals(group)){
				return track.getRhythm();
			}
		}
		return null;
	}

	
}
