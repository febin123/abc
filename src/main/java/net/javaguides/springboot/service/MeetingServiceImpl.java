package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Meeting;
import net.javaguides.springboot.repository.MeetingRepository;


@Service
	
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;
	@Override
	public List<Meeting> getAllMeeting() {
		return meetingRepository.findAll();
	}
	@Override
	public void saveMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		this.meetingRepository.save(meeting);
		
		
	}
	@Override
	public Meeting getMeetingById(long id) {
		Optional<Meeting> optional = meetingRepository.findById(id);
		Meeting meeting = null;
		if (optional.isPresent()) {
			meeting = optional.get();
		} else {
			throw new RuntimeException(" Meeting not found for id :: " + id);
		}
		return meeting;
	}
	@Override
	public void deleteMeetingById(long id) {
		// TODO Auto-generated method stub
		this.meetingRepository.deleteById(id);
		
	}

}
