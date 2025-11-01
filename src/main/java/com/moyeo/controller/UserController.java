package com.moyeo.controller;

import com.moyeo.VO.UserVO;
import com.moyeo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    /**
     * 사용자 목록 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}/list")
    public ResponseEntity<List<UserVO>> userList(@PathVariable Long id) {
        List<UserVO> userList = userService.userList(id);
        return ResponseEntity.ok(userList);
    }

    /**
     * 사용자 추가
     * @param userVO
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<UserVO> createUser(@RequestBody UserVO userVO) {
        UserVO userInfo = userService.addUserInfo(userVO);
        return ResponseEntity.ok(userInfo);
    }

    /**
     * 사용자 프로필 변경
     * @param userVO
     * @return
     */
    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UserVO userVO) {
        int result = userService.updateUserProfile(userVO);
        if (result > 0) {
            UserVO userVO1 = userService.getUserInfo(userVO);
            return ResponseEntity.ok(userVO1.getUserName());
        } else {
            return ResponseEntity.badRequest().body("프로필 수정 실패");
        }
    }

}
