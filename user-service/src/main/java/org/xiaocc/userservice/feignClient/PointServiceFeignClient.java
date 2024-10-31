package org.xiaocc.userservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xiaocc.commonmodule.entity.User;

@FeignClient(value = "point-service")
public interface PointServiceFeignClient {

    @PostMapping("/point/add")
    public String addPoint(@RequestBody User user);
}
