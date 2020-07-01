package pl.hubertlakomski.passiton.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hubertlakomski.passiton.service.home.institution.list.InstitutionListHomeService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionListHomeService institutionListHomeService;

    @RequestMapping("/")
    public String homeAction(Model model){

        model.addAttribute("institutions", institutionListHomeService.getList());

        return "index";
    }
}
