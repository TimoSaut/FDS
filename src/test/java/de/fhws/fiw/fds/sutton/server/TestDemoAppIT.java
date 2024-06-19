package de.fhws.fiw.fds.sutton.server;


import com.github.javafaker.Faker;
import de.fhws.fiw.fds.university.client.models.UniversityClientModel;
import de.fhws.fiw.fds.university.client.rest.UniversityRestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDemoAppIT {
    final private Faker faker = new Faker();
    private UniversityRestClient client;

    @BeforeEach
    public void setUp() throws IOException{
       this.client = new UniversityRestClient();
       this.client.resetDatabase();
    }

    @Test
    public void test_dispatcher_is_available() throws IOException {
        client.start();
        assertEquals(200, client.getLastStatusCode());
    }

    @Test
    public void test_dispatcher_is_get_all_universitys_allowed() throws IOException {
        client.start();
        assertTrue(client.isGetAllUniversitiesAllowed());
    }

    @Test
    public void test_create_university_is_create_university_allowed() throws IOException {
        client.start();
        assertTrue(client.isCreateUniversityAllowed());
    }

    @Test void test_create_university() throws IOException
    {
        client.start();

        var university = new UniversityClientModel();
        university.setName("TUM");
        university.setCountry("Germany");
        university.setDepartmentName("Tompson");
        university.setDepartmentUrl("https://www.tompson.de");
        university.setContactPerson("Mr.Kek");
        university.setPossibleStudentsToSend(2);
        university.setPossibleStudentsToReceive(10);
        university.setSpringSemesterStart("12.12.2024");
        university.setAutumnSemesterStart("01.01.2025");

        client.createUniversity(university);
        assertEquals(201, client.getLastStatusCode());
    }

    @Test void test_create_university_and_get_new_university() throws IOException
    {
        client.start();

        var university = new UniversityClientModel();

        university.setName("TUM");
        university.setCountry("Germany");
        university.setDepartmentName("Tompson");
        university.setDepartmentUrl("https://www.tompson.de");
        university.setContactPerson("Mr.Kek");
        university.setPossibleStudentsToSend(2);
        university.setPossibleStudentsToReceive(10);
        university.setSpringSemesterStart("12.12.2024");
        university.setAutumnSemesterStart("01.01.2025");

        client.createUniversity(university);
        assertEquals(201, client.getLastStatusCode());
        assertTrue( client.isGetSingleUniversityAllowed() );

        client.getSingleUniversity();
        assertEquals(200, client.getLastStatusCode());

        var universityFromServer = client.universityData().getFirst();
        assertEquals( "Germany", universityFromServer.getCountry() );
    }

    @Test void test_create_5_university_and_get_all() throws IOException
    {

        for( int i=0; i<5; i++ ) {
            client.start();

              var university = new UniversityClientModel();
            university.setName(faker.name().firstName());
            university.setCountry(faker.country().name());
            university.setDepartmentName(faker.name().fullName());
            university.setDepartmentUrl(faker.internet().url());
            university.setContactPerson(faker.name().fullName());
            university.setPossibleStudentsToSend(2);
            university.setPossibleStudentsToReceive(5);
            university.setSpringSemesterStart("12.12.2024");
            university.setAutumnSemesterStart("01.01.2025");

            client.createUniversity(university);
            assertEquals(201, client.getLastStatusCode());
        }

        /* Now we call the dispatcher to get the URL to get all universitys */
        client.start();
        assertTrue( client.isCreateUniversityAllowed() );

        client.getAllUniversities();
        assertEquals(200, client.getLastStatusCode());
        assertEquals(5, client.universityData().size());

        /* Set the cursor to the first university, not really necessary, but to make it clear here */
        client.setUniversityCursor(0);
        client.getSingleUniversity();
        assertEquals(200, client.getLastStatusCode());
    }
}
