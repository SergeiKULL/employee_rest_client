package com.sergeikulenkov.spring.rest;

import com.sergeikulenkov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate//с помощью этого кода мы отправляем request
                //и его результат, а точнее тело responseEntity присваиваем новому листу при помощи метода getBody()
                .exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        return null;
    }

    public void saveEmployee(Employee employee) {

    }

    public void deleteEmployee(int id) {

    }
}
