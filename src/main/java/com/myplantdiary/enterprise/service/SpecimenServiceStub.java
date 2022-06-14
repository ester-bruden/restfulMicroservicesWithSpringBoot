package com.myplantdiary.enterprise.service;

import com.myplantdiary.enterprise.dao.IPlantDAO;
import com.myplantdiary.enterprise.dao.ISpecimenDAO;
import com.myplantdiary.enterprise.dto.Plant;
import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SpecimenServiceStub implements ISpecimenService{

    // we have a Service calling 2 different daos
    @Autowired
    private ISpecimenDAO specimenDAO;

    @Autowired
    // to the other end we are going to nedd to add repository annotation to PlantDAO
    private IPlantDAO plantDAO;

    public SpecimenServiceStub() {

    }

    public SpecimenServiceStub(ISpecimenDAO specimenDAO)
    {
        this.specimenDAO = specimenDAO;
    }

    @Override
    public Specimen fetchById(int id) {
        Specimen foundSpecimen = specimenDAO.fetch(id);
        return foundSpecimen;
    }
    public void saveSpecimen(Specimen newSpecimen){

    }

    @Override
    public void delete(int id)throws Exception{
        specimenDAO.delete(id);
    }

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        return specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }

    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }
}
