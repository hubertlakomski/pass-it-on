package pl.hubertlakomski.passiton.web.controllers.management.institution;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.hubertlakomski.passiton.service.management.institution.ManagementInstitutionService;
import pl.hubertlakomski.passiton.service.management.institution.InstitutionDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/institutions")
public class ManagementInstitutionController {

    private final ManagementInstitutionService service;

    @GetMapping
    List<InstitutionDTO> all(){

        return service.findAll();
    }

    @GetMapping("/{id}")
    InstitutionDTO get(@PathVariable Long id){

        return service.get(id);
    }

    @PostMapping
    InstitutionDTO addInstitution(@RequestBody InstitutionDTO institutionDTO){

        return service.save(institutionDTO);
    }

    @PutMapping
    InstitutionDTO updateInstitution(@RequestBody InstitutionDTO institutionDTO){

        return service.update(institutionDTO);
    }

    @DeleteMapping("/{id}")
    void deleteInstitution(@PathVariable Long id){

        service.delete(id);
    }


}
