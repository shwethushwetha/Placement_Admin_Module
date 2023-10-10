package com.cg.am;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class B28AdminModuleApplicationTests {
@Autowired
	AdminRepository aRepo;
	
	//create
@Test
@Order(1)
	public void testCreate() {
		Admin a=new Admin();
		a.setId(1);
		a.setName("Aruna");
		a.setPassword("abc123");
		a.setMall("lulu");
		a.setPhone(994433444);
		aRepo.save(a);
		assertNotNull(aRepo.findById(1).get());	
	}
//Retrieval
@Test
@Order(2)
public void testReadall() {
	List<Admin> list = aRepo.findAll();
	assertThat(list).size().isGreaterThan(0);
}
//Retrieval of single method
@Test
@Order(3)
public void testSingleAdmin() {
	Admin admin = aRepo.findById(1).get();
	assertEquals("lulu",admin.getMall());
}
//Update
@Test
@Order(4)
public void testUpadate() {
	Admin a = aRepo.findById(1).get();
	a.setMall("bda");
	aRepo.save(a);
	assertNotEquals("forum",aRepo.findById(1).get().getMall());
}
//Delete
@Test
@Order(5)
public void testDelete() {
	aRepo.deleteById(1);
	assertThat(aRepo.existsById(1)).isFalse();
}
}

	
