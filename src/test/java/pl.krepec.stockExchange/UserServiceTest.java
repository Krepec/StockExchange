package pl.krepec.stockExchange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.UserRepository;
import pl.krepec.stockExchange.repository.model.UserDAO;
import pl.krepec.stockExchange.service.UserService;

import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository mockUserRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test

    public void shouldAddNewUser(){

        UserDAO userDAO = new UserDAO(16,"Bartek","Nowak", 10.0, "USER");

        when(mockUserRepository.save(refEq(new UserDAO(123,"Adam","Kowalski", 1000.0, "USER")))).thenReturn(userDAO);

        Integer result = userService.addNewUser(new UserDTO(123,"Adam","Kowalski", 1000.0, "USER"));

        // then
        Assert.assertEquals(userDAO.getId(),result);
    }

}

