package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Meeting")
public class Meeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Meeting_Name")
	private String meeting_Topic;
	
	@Column(name="Meeting_Subject")
	private String subject;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMeeting_Topic() {
		return meeting_Topic;
	}
	public void setMeeting_Topic(String meeting_Topic) {
		this.meeting_Topic = meeting_Topic;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
