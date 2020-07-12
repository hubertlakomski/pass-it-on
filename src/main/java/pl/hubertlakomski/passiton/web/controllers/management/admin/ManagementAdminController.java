package pl.hubertlakomski.passiton.web.controllers.management.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.hubertlakomski.passiton.service.management.admin.AdminDTO;
import pl.hubertlakomski.passiton.service.management.admin.ManagementAdminService;

import java.util.Set;

@RestController
@RequestMapping("/management/admins")
@RequiredArgsConstructor
public class ManagementAdminController {

    private final ManagementAdminService service;

    @GetMapping
    Set<AdminDTO> findAll(){

        return service.findAll();
    }

    @GetMapping("/{id}")
    AdminDTO get(@PathVariable Long id){

        return service.get(id);
    }

    @PostMapping
    AdminDTO add(@RequestBody AdminDTO adminDTO){

        return service.save(adminDTO);
    }

    @PutMapping
    AdminDTO update(@RequestBody AdminDTO adminDTO){

        return service.update(adminDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){

        service.delete(id);
    }


}
