package org.gtvapi.controller;

import lombok.RequiredArgsConstructor;
import org.gtvapi.service.UserFollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserFollowService userFollowService;

    @PostMapping("follow")
    public ResponseEntity<String> followUser(@RequestParam(value = "followedId")  Long followedId) {
        userFollowService.followUser(followedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("follow")
    public ResponseEntity<Boolean> isFollowUser(@RequestParam(value = "followedId")  Long followedId) {
        return ResponseEntity.ok(userFollowService.isUserFollow(followedId));
    }
}
