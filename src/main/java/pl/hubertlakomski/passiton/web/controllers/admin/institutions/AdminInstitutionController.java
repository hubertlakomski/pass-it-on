package pl.hubertlakomski.passiton.web.controllers.admin.institutions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.hubertlakomski.passiton.service.admin.institution.AdminInstitutionService;
import pl.hubertlakomski.passiton.service.admin.institution.InstitutionDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/institutions")
public class AdminInstitutionController {

    private final AdminInstitutionService service;

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
