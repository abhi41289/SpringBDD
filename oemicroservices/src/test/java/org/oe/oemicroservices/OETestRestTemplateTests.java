package org.oe.oemicroservices;

import org.junit.jupiter.api.Test;
import org.oe.oemicroservices.model.Address;
import org.oe.oemicroservices.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OETestRestTemplateTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void testGetEmployeeByID() {

        //Arrange
        final String baseURL = "http://localhost:" + port + "/employees/2";

        var employee = Employee.builder()
                .id(2)
                .name("Lizzy")
                .address(Address.builder().city("Hyderabad").street("India").country("Eseva Lane").build())
                .email("Lizzy@test.com")
                .phone(54321)
                .build();

        //Act
        var responseEntity = this.restTemplate.getForObject(baseURL, Employee.class);

        //Assert
        assertThat(responseEntity).isEqualTo(employee);
    }

    @Test
    public void testGetAllEmployees(){
        //Arrange
        final String baseURL = "http://localhost:" + port + "/employees";
        var employee = Employee.builder()
                .id(2)
                .name("Lizzy")
                .address(Address.builder().city("Hyderabad").street("India").country("Eseva Lane").build())
                .email("Lizzy@test.com")
                .phone(54321)
                .build();
        //Act

        var responseEntity = this.restTemplate.getForObject(baseURL, Employee[].class);

        var responseEmployee = Arrays.stream(responseEntity)
                                .filter(x -> x.getId() == 2)
                                .findFirst()
                                .get();

        //Assert
        assertThat(responseEmployee).isEqualTo(employee);

    }

    @Test
    public void testPostEmployee(){

        //Arrange
        final String baseURL = "http://localhost:" + port + "/AddEmployee";
        var employee = Employee.builder()
                .id(3)
                .name("Raj")
                .address(Address.builder().city("Hyderabad").street("India").country("Eseva Lane").build())
                .email("Raj@test.com")
                .phone(231456)
                .build();

        //Act
        var responseEntity = this.restTemplate.postForObject(baseURL, employee, Employee[].class);
        var responseEmployee = Arrays.stream(responseEntity)
                                .filter(x ->x.getId() == 3)
                                .findFirst()
                                .get();

        //Assert
        assertThat(responseEmployee).isEqualTo(employee);



    }

}
