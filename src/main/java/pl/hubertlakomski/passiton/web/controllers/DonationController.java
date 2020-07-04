package pl.hubertlakomski.passiton.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.hubertlakomski.passiton.service.donation.DonationData;
import pl.hubertlakomski.passiton.service.donation.DonationService;

import javax.validation.Valid;

@Controller("/donation")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @GetMapping
    public String prepareFormPage(Model model){

        model.addAttribute("categories", donationService.getListOfCategories());
        model.addAttribute("institutions", donationService.getListOfInstitutions());

        return "form";
    }

    @PostMapping
    public String processFormPage(@Valid DonationData data, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form";
        }

        donationService.saveDonation(data);

        return "home";
    }

}
