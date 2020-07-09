package pl.hubertlakomski.passiton.web.controllers.management;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/management")
public class AdminController {

    @GetMapping
    public String prepareAdminPage(){

        return "admin";
    }

}
