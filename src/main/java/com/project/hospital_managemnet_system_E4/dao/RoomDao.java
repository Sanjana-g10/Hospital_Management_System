package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.RoomIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.RoomRepo;


@Repository

public class RoomDao {

	
	
	@Autowired
	RoomRepo roomRepo;
	
	
	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public Room updateRoomById(int oldRoomId, Room newRoom) {
		Optional<Room> room = roomRepo.findById(oldRoomId);
		if(room.isEmpty()) {
			return null;
		}else {
			return room.get();
		}
//		newRoom.setRoomId(oldRoomId);
	//	return RoomRepo.save(newRoom);
	}
	
	
	
	public Room fetchRoomById(int roomId) {
		Optional<Room> room = roomRepo.findById(roomId);
		if(room.isEmpty()) {
			return null;
		}else 
//		return roomRepo.findById(roomId).get();
			return room.get();
	}
	
	
	public Room deleteRoomById(int roomId) {
		Optional<Room> optionalRoom = roomRepo.findById(roomId);
		if(optionalRoom.isPresent()) {
			Room room = optionalRoom.get();
			 roomRepo.delete(room);
		        return room;
		}else {
			throw new RoomIdNotFound();
		}
	}
//	//	Room Room=RoomRepo.findById(RoomId).get();
//		Room room=fetchRoomById(roomId);
//		roomRepo.delete(room);
//		return room;
//	}
	
	public List<Room> fetchAllRoom(){
		return roomRepo.findAll();
	}
}
