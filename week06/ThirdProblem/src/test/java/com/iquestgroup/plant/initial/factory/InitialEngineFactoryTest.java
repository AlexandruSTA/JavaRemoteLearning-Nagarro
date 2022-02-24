package com.iquestgroup.plant.initial.factory;

import com.iquestgroup.plant.initial.domain.Employee;
import com.iquestgroup.plant.initial.domain.Engine;
import com.iquestgroup.plant.initial.domain.EngineComponent;
import com.iquestgroup.plant.initial.exception.InsufficientStockException;
import com.iquestgroup.plant.initial.exception.UnauthorizedEmployeeException;
import com.iquestgroup.plant.initial.exception.UnqualifiedEmployeeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InitialEngineFactoryTest {
    private static EngineFactory engineFactory;
    private static List<Employee> employees = new ArrayList<>();
    private static List<EngineComponent> engineComponents = new ArrayList<>();

    @BeforeAll
    static void setup() {
        Employee firstEmployee = new Employee("John Doe", true, true);
        Employee secondEmployee = new Employee("Alfred Knight", false, true);
        Employee thirdEmployee = new Employee("Peter Wayne", false, false);
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        EngineComponent firstEngineComponent = new EngineComponent("Cylinder Block", 100);
        EngineComponent secondEngineComponent = new EngineComponent("Cylinder Head", 5);
        EngineComponent thirdEngineComponent = new EngineComponent("Crankshaft", 5);
        engineComponents.add(firstEngineComponent);
        engineComponents.add(secondEngineComponent);
        engineComponents.add(thirdEngineComponent);
        engineFactory = new EngineFactory(employees, engineComponents);
    }

    @Test
    void checkUnassignedEmployee() {
        try {
            List<Engine> manufacturedEngines = engineFactory
                    .manufactureEngines(10, new Employee("Bill Stewart", false, true));
        } catch (UnauthorizedEmployeeException exception) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void manufactureEnginesWithUnqualifiedEmployee() {
        try {
            List<Engine> manufacturedEngines = engineFactory.manufactureEngines(10, employees.get(2));
        } catch (UnqualifiedEmployeeException exception) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void manufactureEnginesWithInsufficientStock() {
        try {
            List<Engine> manufacturedEngines = engineFactory.manufactureEngines(10, employees.get(0));
        } catch (InsufficientStockException exception) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void manufactureEngines() {
        List<Engine> manufacturedEngines = engineFactory.manufactureEngines(1, employees.get(0));
        Assertions.assertEquals(1, manufacturedEngines.size());
    }

    @Test
    void verifyComponentsPerEngine() {
        Assertions.assertEquals(3, engineFactory.getComponentsPerEngine());
    }

}