package pl.hubertlakomski.passiton.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.hubertlakomski.passiton.service.donation.add.DonationAddService;

@Controller("/donation")
@RequiredArgsConstructor
public class DonationController {

    private final DonationAddService donationAddService;

    @GetMapping
    public String prepareFormPage(Model model){

        model.addAttribute("categories", donationAddService.getListOfCategories());
        model.addAttribute("institutions", donationAddService.getListOfInstitutions());

        return "form";
    }

}
