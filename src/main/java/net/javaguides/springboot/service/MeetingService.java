package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Meeting;

public interface MeetingService {
List<Meeting> getAllMeeting();
void saveMeeting(Meeting meeting);


Meeting getMeetingById(long id);

void deleteMeetingById(long id);
}
