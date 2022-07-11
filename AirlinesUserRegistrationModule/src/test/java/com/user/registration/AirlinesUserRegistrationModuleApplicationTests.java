package com.user.registration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.registration.entities.UserEntity;
import com.user.registration.helper.UserEntityDto;
import com.user.registration.repositories.UserEntityRepository;
import com.user.registration.services.UserEntityService;
import com.user.registration.servicesImpl.UserEntityServiceImpl;

@SpringBootTest
class AirlinesUserRegistrationModuleApplicationTests {

	@Autowired
	private UserEntityService userEntityService;
	
	@MockBean
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Test
	public void createUserTest() {
		UserEntity userEntity = UserEntity.builder()
				
				.firstName("Mayur")
				.lastName("Kumbhar")
				.address("Benkar Vasti")
				.contactNo(738543691)
				.city("Sangli")
				.state("Mahrashtra")
				.country("India")
				.gender("M")
				.emailId("mayuresh@gmail.com")
				.customerId(123)
				.password("Mayur@123").build();
			
		
		when(userEntityRepository.save(userEntity)).thenReturn(userEntity);
		assertThat(userEntityService.createUser(this.modelMapper.map(userEntity, UserEntityDto.class))).isEqualToComparingFieldByField(userEntity);
	}
	
	
}
