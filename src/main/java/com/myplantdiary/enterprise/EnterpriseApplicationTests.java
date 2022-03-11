package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class EnterpriseApplicationTests {
@Autowired
    private ISpecimenService specimenService;
    private Specimen specimen = new Specimen();

    @Test
    void contextLoads() {
    }

    @Test
    void fetchSpecimenByID_returnsRedbudForID83() throws Exception  {
        givenSpecimenDataAreAvailable();
        whenSearchSpecimenWithID83();
        thenReturnOneEasternRedbudSpecimenForID83();
    }

    private void givenSpecimenDataAreAvailable() throws Exception {
        /*
        Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
        specimenService = new SpecimenServiceStub(specimenDAO);
         */
    }

    private void whenSearchSpecimenWithID83() {
        specimen = specimenService.fetchById(83);
    }

    private void thenReturnOneEasternRedbudSpecimenForID83() {
        String description = specimen.getDescription();
        assertEquals("Eastern Redbud", description);
    }

}
