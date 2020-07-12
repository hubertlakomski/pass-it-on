package pl.hubertlakomski.passiton.web.controllers.user.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.hubertlakomski.passiton.service.data.DonationDTO;
import pl.hubertlakomski.passiton.service.user.donation.UserDonationService;

import java.util.List;

@RestController
@RequestMapping("/donations")
@RequiredArgsConstructor
public class UserDonationController {

    private final UserDonationService service;

    @GetMapping
    public List<DonationDTO> findAll(@RequestParam Long userId){

        return service.getListOfUserDonations(userId);
    }

}
