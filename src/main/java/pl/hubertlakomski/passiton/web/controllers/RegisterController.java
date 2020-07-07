package pl.hubertlakomski.passiton.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hubertlakomski.passiton.service.register.RegisterData;
import pl.hubertlakomski.passiton.service.register.RegisterService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping
    public String prepareRegisterPage(Model model){

        model.addAttribute("registerData", new RegisterData());

        return "register";
    }

    @PostMapping
    public String processRegisterPage(@Valid RegisterData data, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            return "register";
        }

        registerService.process(data);

        return "index";
    }

}
