package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SpecimenDAOStub implements ISpecimenDAO {
    /* if we use a list and we check for one element we have to go through each element until we find the id
        List<Specimen> allSpecimens = new ArrayList<Specimen>();
     */
    // after = we use generics that will inherit what we have in the left
    HashMap<Integer, Specimen> allSpecimens = new HashMap<>();

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        Integer specimenId = specimen.getPlantId();
        allSpecimens.put(specimenId, specimen);
        return specimen;
    }

    @Override
    public List<Specimen> fetchAll() {
        List<Specimen> returnSpecimens = new ArrayList(allSpecimens.values());
        return returnSpecimens;
    }

    @Override
    public Specimen fetch(int id) {
        return allSpecimens.get(id);
    }

    @Override
    public void delete(int id) {
        allSpecimens.remove(id);

    }
}
