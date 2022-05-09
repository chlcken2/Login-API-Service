package service.dev.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.dev.advice.exception.CEmailSignInFailedException;
import service.dev.config.security.JwtTokenProvider;
import service.dev.entity.User;
import service.dev.model.response.CommonResult;
import service.dev.model.response.SingleResult;
import service.dev.repository.UserJpaRepo;
import service.dev.service.ResponseService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@RequestParam String id, @RequestParam String password) {
        User user = userJpaRepo.findById(id).orElseThrow(CEmailSignInFailedException::new);
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CEmailSignInFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getIdx())));

    }

    @PostMapping(value = "/signup")
    public CommonResult signin(

                               @RequestParam(required = false) String id,
                               @RequestParam(required = false) String password,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String mobile,
                               @RequestParam(required = false) String email) {

        userJpaRepo.save(User.builder()
                .id(id)
                .password(passwordEncoder.encode(password))
                .name(name)
                .mobile(mobile)
                .email(email)
                .build());
        return responseService.getSuccessResult();
    }
}