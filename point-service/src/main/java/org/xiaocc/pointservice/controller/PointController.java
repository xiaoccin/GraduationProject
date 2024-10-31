package org.xiaocc.pointservice.controller;

import org.springframework.web.bind.annotation.*;
import org.xiaocc.commonmodule.entity.User;

@RestController
@RequestMapping(value = "/point")
public class PointController {
    @PostMapping(value = "/add")
    public String addPoint(@RequestBody User user){
        return "point get userid " + user.getAccount();
    }
}
