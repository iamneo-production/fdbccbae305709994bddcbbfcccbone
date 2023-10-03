
package com.example.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.examly.springapp.SpringappApplication;


@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;


@Test 
    public void testcontrollerfolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testcontrollerfile() { 
        String filePath = "src/main/java/com/examly/springapp/controller/CrackersController.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testModelFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testModelFile() { 
        String filePath = "src/main/java/com/examly/springapp/model/Crackers.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testrepositoryfolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/repository"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testrepositoryFile() { 
        String filePath = "src/main/java/com/examly/springapp/repository/CrackersRepo.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }

	@Test 
    public void testServiceFolder() { 
        String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your directory 
        File directory = new File(directoryPath); 
        assertTrue(directory.exists() && directory.isDirectory()); 
    }
    
    @Test 
    public void testServieFile() { 
        String filePath = "src/main/java/com/examly/springapp/service/ApiService.java"; 
        // Replace with the path to your file 
        File file = new File(filePath); 
        assertTrue(file.exists() && file.isFile()); 
    }



	@Test
    public void addDetails() throws Exception {

		 
		String st = "{\"crackersId\": 1000,\"crackersName\": \"Demo\",\"crackersPrice\": \"100rs\",\"crackersBrand\": \"demo address\",\"manufacturedIn\": \"chennai\", \"crackersType\": \"night\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(st)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(true))
	        	.andReturn();
	    
    }


	@Test
	void getById() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/crackers/1000")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.manufacturedIn").value("chennai"))
						.andReturn();
	}

	@Test
	void getBybrandName() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/brand/demo address")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getByName() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/name/Demo")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getBynameBrandName() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/Demo/demo address")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}






	

}
