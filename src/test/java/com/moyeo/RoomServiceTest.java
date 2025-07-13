package com.moyeo;

import com.moyeo.VO.RoomVO;
import com.moyeo.dto.RoomDTO;
import com.moyeo.dto.RoomPasswordDTO;
import com.moyeo.dto.UserDTO;
import com.moyeo.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;

    @Test
    void createAndFetchRoom() {
        RoomPasswordDTO pwd = new RoomPasswordDTO("one", "two", "three");
        UserDTO userDTO = new UserDTO("user1", 1, "#FFFFFF");
        RoomDTO dto = new RoomDTO(null, pwd, "TestRoom", "String", 5, 2, userDTO);

        Long id = roomService.createRoom(dto);

        RoomVO result = roomService.getRoom(id);
        System.out.println("####result: " + result.getUserInfo().getUserName()
                        + ", " + result.getUserInfo().getUserImg()
                        + ", " + result.getUserInfo().getUserColor());
        assertThat(result).isNotNull();
        assertThat(result.getRoomName()).isEqualTo("TestRoom");
        assertThat(result.getUserInfo().getUserName()).isEqualTo("user1");
    }
}
