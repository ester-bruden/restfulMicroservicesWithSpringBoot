package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The controller fro Plant Diary REST endpoints and web UI
 * <p>
 * This class handles the CRUD operations for My Plant Diary specimens, via HTTP actions.
 * </p>
 * <p>
 * This class also serves HTML based web pages, for UI interactions with plant specimens.
 * </p>
 *
 * @author Ester Bruden
 */

@Controller
public class PlantDiaryController {
    /**
     * Controller part of MVC
     * Controllers interpret user input and transform it into a model that is represented to the user by the view
     * The @Controller annotation acts as a stereotype for the annotated class, indicating its role.
     * The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations
     */

    /**
     * Handle the root (/) endpoint and return a start page.
     *
     * @return
     */
    @Autowired
    ISpecimenService specimenService;

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Operations we are going to do with specimen
     */
    @GetMapping("/specimen")
    @ResponseBody
    public List<Specimen> fetchAllSpecimens() {

        return specimenService.fetchAll();
    }

    /**
     * Create a new specimen object, given the data provided.
     * <p>
     * returns one of the following status codes:
     * 201: successfully created a new specimen.
     * 409: unable to create a specimen, because it already exists.
     *
     * @param sepcimen a JSON representation of a specimen object.
     * @return the newly created specimen object.
     */
    @GetMapping("/specimen/{id}/")
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id) {
        /**
         * GetMapping-> get means read data
         * @PathVariable("id") will take the id from /specimen/{id}
         * and replace the value into the String id parameter
         * so that we can fetch the specific specimen
         */
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create a new specimen object, given the data provided.
     * <p>
     * returns one of the following status codes:
     * 201: successfully created a new specimen.
     * 409: unable to create a specimen, because it already exists.
     *
     * @param sepcimen a JSON representation of a specimen object.
     * @return the newly created specimen object.
     */

    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen) {
        /**
         * you receive the specimen as a Json representation
         * @RequestBody: can use some naming conventioins to parse through Json
         */
        Specimen newSpecimen = null;
        try {
            newSpecimen = specimenService.save(specimen);
        } catch (Exception e) {
            // TODO add logging
        }
        return newSpecimen;
    }

    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }


}
