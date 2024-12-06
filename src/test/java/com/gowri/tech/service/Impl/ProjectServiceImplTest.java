package com.gowri.tech.service.Impl;
/**
 * @author -NaveenWodeyar
 * @date -06-Dec-2024
 * @time - 11:50:19 pm
 * @location -
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.gowri.tech.entity.Projects;
import com.gowri.tech.service.ProjectService;

class ProjectServiceImplTest {

    @Mock
    private ProjectsRepository projectsRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Projects project;

    @BeforeEach
    void setUp() {
        // Create a sample project for testing
        project = new Projects();
        project.setId(1L);
        project.setName("Project A");
        project.setDescription("Description of Project A");
    }

    @Test
    void testSaveProducts() {
        projectService.saveProducts();
    }

    @Test
    void testGetProducts() {
        // Act: Call getProducts method
        List<Projects> result = projectService.getProducts();

        // Assert: Verify that the repository method was called and the result is as expected
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testGetProduct() {
        // Act: Call getProduct method
        Projects result = projectService.getProduct();

        // Assert: Verify that the result is the expected project
        assertNotNull(result);
    }
}
