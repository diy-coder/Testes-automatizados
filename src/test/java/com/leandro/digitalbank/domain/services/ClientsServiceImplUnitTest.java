package com.leandro.digitalbank.domain.services;

import com.br.digitalMarketPlace.modules.clients.domain.dtos.IClientDTO;
import com.br.digitalMarketPlace.modules.clients.domain.entities.Client;
import com.br.digitalMarketPlace.modules.clients.domain.services.impl.ClientsServiceImpl;
import com.br.digitalMarketPlace.modules.clients.infrastructure.repositories.mysql.SpringDataH2ClientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ClientsServiceImplUnitTest {
    private SpringDataH2ClientsRepository clientsRepository;
    private ClientsServiceImpl tested;

    @BeforeEach
    void setUp() {
        clientsRepository = mock(SpringDataH2ClientsRepository.class);
        tested = new ClientsServiceImpl(clientsRepository);
    }

    @Test
    void shouldCreateClient_thenSaveIt() {
        final IClientDTO clientDTO = new IClientDTO();
        clientDTO.setFirstName("Jonh");
        clientDTO.setLastName("Doe");
        clientDTO.setEmail("jonhdoe@mail.com");
        clientDTO.setDateOfBirth("16/11/1993");
        clientDTO.setCpf("04694757301");

        final String id = tested.createItem(clientDTO);

        verify(clientsRepository).save(any(Client.class));
        assertNotNull(id);
    }

    @Test
    void shouldCreateClient_thenThrowValidationException() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        final IClientDTO clientDTO = new IClientDTO();
        clientDTO.setFirstName(""); // @NotBlank
        clientDTO.setLastName("Doe");
        clientDTO.setEmail("jonhdoe.mail.com"); // @Email
        clientDTO.setDateOfBirth("16/11/1993");
        clientDTO.setCpf("04694757301");

        Set<ConstraintViolation<IClientDTO>> constraintViolations = validator.validate(clientDTO);

        verify(clientsRepository, times(0)).save(any(Client.class));

        assertTrue(isExpectedConstraintViolated(NotBlank.class, constraintViolations));
        assertTrue(isExpectedConstraintViolated(Email.class, constraintViolations));
    }

    public boolean isExpectedConstraintViolated(Class<?> constraintClass,
                                                Set<ConstraintViolation<IClientDTO>> constraintViolations) {
        for (ConstraintViolation<IClientDTO> violaton : constraintViolations) {
            if (constraintClass.equals(violaton.getConstraintDescriptor().getAnnotation().annotationType())) {
                return true;
            }
        }
        return false;
    }
}
