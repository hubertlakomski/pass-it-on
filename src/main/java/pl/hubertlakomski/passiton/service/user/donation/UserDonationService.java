package pl.hubertlakomski.passiton.service.user.donation;

import pl.hubertlakomski.passiton.service.data.DonationDTO;

import java.util.List;

public interface UserDonationService {

    List<DonationDTO> getListOfUserDonations(Long userId);

}
