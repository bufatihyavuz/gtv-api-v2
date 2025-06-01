package org.gtvapi.controller;

import lombok.RequiredArgsConstructor;
import org.gtvapi.dto.responsedto.UserResponseDTO;
import org.gtvapi.service.UserFollowService;
import org.gtvapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserFollowService userFollowService;
    private final UserService userService;

    @PostMapping("follow")
    public ResponseEntity<String> followUser(@RequestParam(value = "followedId")  Long followedId) {
        userFollowService.followUser(followedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("is-following")
    public ResponseEntity<Boolean> isFollowUser(@RequestParam(value = "followedId")  Long followedId) {
        return ResponseEntity.ok(userFollowService.isFollowing(followedId));
    }

    @GetMapping("my-following")
    public ResponseEntity<List<UserResponseDTO>> myFollowings() {
        return ResponseEntity.ok(userService.myFollowings());
    }
}
