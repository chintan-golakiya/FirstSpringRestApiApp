package com.chintan.FirstSpringRestApi.repository;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.chintan.FirstSpringRestApi.dao.AlienRepo;
import com.chintan.FirstSpringRestApi.model.Alien;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AlienRepositoryTests {

	@Autowired
	private AlienRepo alienRepo;
	
	@Test
	public void AlienRepo_findByAname() {
		Alien testAlien = new Alien();
		testAlien.setAname("test aname");
		testAlien.setTech("test tech");
		
		Alien savedAlien = alienRepo.save(testAlien);
		
		List<Alien> list = alienRepo.findByAname("test aname");
		
		Assertions.assertThat(list.size()).isGreaterThanOrEqualTo(1);
		Assertions.assertThat(list.get(0).getAid()).isEqualTo(savedAlien.getAid());
		Assertions.assertThat(list.get(0).getAname()).isEqualTo(savedAlien.getAname());
		Assertions.assertThat(list.get(0).getTech()).isEqualTo(savedAlien.getTech());
	}
	
	@Test
	public void AlienRepo_findAllByAidGreaterThan() {
		List<Alien> list = alienRepo.findAllByAidGreaterThan(101);
		int size = list.size();
		
		for(int i=0;i<size;i++) {
			Assertions.assertThat(list.get(i).getAid()).isGreaterThan(101);
		}
		Assertions.assertThat(list.size()).isEqualTo(4);
	}
	
	@Test
	public void AlienRepo_anyMethodName() {
		List<Alien> list = alienRepo.anyMethodName(101);
		int size = list.size();
		String s = "";
		for(int i=0;i<size;i++) {
			Assertions.assertThat(list.get(i).getAid()).isNotEqualTo(101);
			Assertions.assertThat(list.get(i).getAname().compareTo(s)).isGreaterThan(0);
		}
	}
}
