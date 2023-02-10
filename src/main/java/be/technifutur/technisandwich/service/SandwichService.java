package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.model.dto.SandwichDTO;
import be.technifutur.technisandwich.model.entity.Sandwich;
import be.technifutur.technisandwich.model.form.SandwichInsertForm;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface SandwichService {

    void createSandwich(@Valid SandwichInsertForm form);

    SandwichDTO getOne(Long id);

    List<SandwichDTO> getAll();

    void delete(long id);

    void updateSandwich(long id, Map<String, String> updateData);
}
