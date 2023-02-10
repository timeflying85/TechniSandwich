package be.technifutur.technisandwich.controller;


import be.technifutur.technisandwich.model.dto.SandwichDTO;
import be.technifutur.technisandwich.model.form.SandwichInsertForm;
import be.technifutur.technisandwich.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sand")
public class SandwichController {

    private final SandwichService service;


    public SandwichController(SandwichService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid SandwichInsertForm form){

        service.createSandwich( form );

    }

    @GetMapping("/{id:[0-9]+}")
    public SandwichDTO getOne(long id){

        return service.getOne(id);

    }

    @GetMapping("/all")
    public List<SandwichDTO> getAll(){

        return service.getAll();

    }

    @DeleteMapping("/{id:[0-9]+}")
    public void delete(@PathVariable long id){

        service.delete(id);

    }

    @PatchMapping("/{id:[0-9]+}/update")
    public void updateSandwich(@PathVariable long id, @RequestParam Map<String, String> params){

        service.updateSandwich(id, params);

    }


}
