package pl.hubertlakomski.passiton.service.user.donation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.hubertlakomski.passiton.domain.models.Donation;
import pl.hubertlakomski.passiton.domain.repositories.DonationRepository;
import pl.hubertlakomski.passiton.service.data.DonationDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultUserDonationService implements UserDonationService {

    private final ModelMapper modelMapper;
    private final DonationRepository donationRepository;

    @Override
    public List<DonationDTO> getListOfUserDonations(Long userId) {

        return donationRepository.findAllByDonatingUserId(userId)
                .stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private DonationDTO convertToDto(Donation donation){

        return modelMapper.map(donation, DonationDTO.class);
    }
}
