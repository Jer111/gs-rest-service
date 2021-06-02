package com.example.restservice;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Column(name = "groupname")
	private String group;
	@Column(name = "name")
	private final String name;
	@Column(name = "score")
	private int xscore;
	

	public User(String name, int score) {
		this.name = name;
		this.xscore = score;
	}


	public String getName() {
		return name;
	}

	public int getScore(){
		return xscore;
	}

	public void setScore(int score){
		this.xscore = score;
	}

	public String toString(){
		return String.format("Group=%s : Name=%s : score=%d", group, name, xscore);
	}
}
