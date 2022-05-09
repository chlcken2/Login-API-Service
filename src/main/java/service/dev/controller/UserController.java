package service.dev.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import service.dev.advice.exception.CUserNotFoundException;
import service.dev.entity.User;
import service.dev.model.response.CommonResult;
import service.dev.model.response.ListResult;
import service.dev.model.response.SingleResult;
import service.dev.repository.UserJpaRepo;
import service.dev.service.ResponseService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService; // 결과를 처리할 Service


    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return responseService.getListResult(userJpaRepo.findAll());
    }


    @GetMapping(value = "/user")
    public SingleResult<User> findUser() {
        // SecurityContext에서 인증받은 회원의 정보를 얻어온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName(); //security에서 값을 받아옴 -> getName으로 가져옴 name = id
        // 결과데이터가 단일건인경우 getSingleResult를 이용해서 결과를 출력한다.
        return responseService.getSingleResult(userJpaRepo.findById(id).orElseThrow(CUserNotFoundException::new));
    }

    @PutMapping(value = "/user")
    public SingleResult<User> modify(@RequestParam Long idx, @RequestParam String mobile, @RequestParam String email) {
        User user = userJpaRepo.getOne(idx);
        user.modify(mobile, email);

//        User user = User.modify(idx, mobile, email);

        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @DeleteMapping(value = "/user/{idx}")
    public CommonResult delete(@PathVariable long idx) {
        userJpaRepo.deleteById(idx);
        // 성공 결과 정보만 필요한경우 getSuccessResult()를 이용하여 결과를 출력한다.
        return responseService.getSuccessResult();
    }
}