package be.technifutur.technisandwich.controller;


import be.technifutur.technisandwich.model.form.SandwichInsertForm;
import be.technifutur.technisandwich.service.PanierService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panier")
public class PanierController {

    private final PanierService panierService;


    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @PostMapping("/add")
    public void addSandwich(@RequestBody SandwichInsertForm form) {

        panierService.addSandwich(form);

    }

    @PostMapping("/addToPanier/{id}")
    public void addSandwichToPanier(@PathVariable long id, Authentication authentication){

        panierService.addSandwichToPanier(id, (String) authentication.getPrincipal());

    }


}
