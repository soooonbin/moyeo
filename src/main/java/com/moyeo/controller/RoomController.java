package com.moyeo.controller;

import com.moyeo.VO.RoomVO;
import com.moyeo.dto.RoomDTO;
import com.moyeo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    /**
     * 채팅방 생성 후 채팅방 조회
     * @param dto
     * @return
     */
    @PostMapping("/room")
    public ResponseEntity<RoomVO> createRoom(@RequestBody RoomDTO dto) {
        Long id = roomService.createRoom(dto);
        return getRoom(id);
    }

    /**
     * 채팅방 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoomVO> getRoom(@PathVariable Long id) {
        RoomVO room = roomService.getRoom(id);
        return ResponseEntity.ok(room);
    }

}
