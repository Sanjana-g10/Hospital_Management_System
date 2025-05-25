package com.project.hospital_managemnet_system_E4.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.RoomDao;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.RoomIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class RoomService {

	
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	ResponseStructure<Room> responseStructure;

	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		responseStructure.setMessage("Successfully room created");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(roomDao.saveRoom(room));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.CREATED); 
	}

	public ResponseEntity<ResponseStructure<Room>> updateRoomById(int oldRoomId, Room newRoom) {
		Room room = roomDao.fetchRoomById(oldRoomId);
		if (room != null) {
		responseStructure.setMessage("Successfully room updated by ID");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(roomDao.updateRoomById(oldRoomId, newRoom));
      return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		}else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(int roomId) {
		Room room = roomDao.fetchRoomById(roomId);
		if (room != null) {
			responseStructure.setMessage("Successfully room fetched by ID");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(roomDao.fetchRoomById(roomId));
			return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new RoomIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(int roomId) {
		Room room = roomDao.fetchRoomById(roomId);
		if (room != null) {
			responseStructure.setMessage("Successfully room deleted by ID");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(roomDao.deleteRoomById(roomId));
	       return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		}else {
			throw new RoomIdNotFound();
		}
		
	}

	public List<Room> fetchAllRoom() {
		return roomDao.fetchAllRoom();
	}
}
