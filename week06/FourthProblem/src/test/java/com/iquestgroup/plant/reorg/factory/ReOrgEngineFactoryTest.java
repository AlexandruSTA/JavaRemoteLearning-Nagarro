package com.iquestgroup.plant.reorg.factory;

import com.iquestgroup.plant.reorg.domain.Employee;
import com.iquestgroup.plant.reorg.domain.Engine;
import com.iquestgroup.plant.reorg.exception.UnqualifiedEmployeeException;
import com.iquestgroup.plant.reorg.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ReOrgEngineFactoryTest {

    private static Employee employee;
    private EngineFactory engineFactory;

    @Mock
    EmployeeService employeeServiceMock;

    @BeforeAll
    static void setup() {
        employee = new Employee("John Doe");
    }

    @Test
    void initializeEngineFactory() {
        assertNotNull(employeeServiceMock);
        engineFactory = new EngineFactory(employeeServiceMock);
        Assertions.assertEquals(false, employeeServiceMock.isAssemblyLineWorker(employee));
        Assertions.assertEquals(false, employeeServiceMock.isAdministrator(employee));
        try {
            List<Engine> manufacturedEngines = engineFactory.manufactureEngines(10, employee);
        } catch (UnqualifiedEmployeeException exception) {
            Assertions.assertTrue(true);
        }
    }


}