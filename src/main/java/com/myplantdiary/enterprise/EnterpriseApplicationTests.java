package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dao.ISpecimenDAO;
import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import com.myplantdiary.enterprise.service.SpecimenServiceStub;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.testng.annotations.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class EnterpriseApplicationTests {

    private ISpecimenService specimenService;
    private Specimen specimen = new Specimen();

    @MockBean
    private ISpecimenDAO specimenDAO;


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
        Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
        specimenService = new SpecimenServiceStub(specimenDAO);
    }

    private void whenSearchSpecimenWithID83() {
        specimen = specimenService.fetchById(83);
    }

    private void thenReturnOneEasternRedbudSpecimenForID83() {
        String description = specimen.getDescription();
        assertEquals("Eastern Redbud", description);
    }

    // MOKITO

    @Test
    void saveSpecimen_validateReturnSpecimenWithLatitudeAndLongitude() throws Exception  {
        givenSpecimenDataAreAvailable();
        whenUserCreatesANewSpecimenAndSaves();
        thenCrateNewSpecimenRecordAndReturnIt();
    }

    private void whenUserCreatesANewSpecimenAndSaves() {
        specimen.setLatitude("39.74");
        specimen.setLongitude("-84.51");
    }

    private void thenCrateNewSpecimenRecordAndReturnIt() throws Exception  {
        Specimen createdSpecimen = specimenService.save(specimen);
        assertEquals(specimen, createdSpecimen);
        verify(specimenDAO, atLeastOnce()).save(specimen);
    }

}
