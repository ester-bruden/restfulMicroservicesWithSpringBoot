package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PlantDiaryController {
    /**
     * Controller part of MVC
     */

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Operations we are going to do with specimen
     */
    @GetMapping("/specimen")
    public ResponseEntity fetchAllSpecimens() {
        return new ResponseEntity(HttpStatus.OK);
    }

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

    @PostMapping(value="/specimen", consumes="application/json", produces="application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen) {
        /**
         * you receive the specimen as a Json representation
         * @RequestBody: can use some naming conventioins to parse through Json
         */
        return specimen;
    }

    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }


}
