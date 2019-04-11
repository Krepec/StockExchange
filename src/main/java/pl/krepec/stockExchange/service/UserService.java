package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.UserRepository;
import pl.krepec.stockExchange.repository.model.UserDAO;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO mapUser(UserDAO userDAO) {
        return new UserDTO(userDAO.getId(), userDAO.getUserName(), userDAO.getPassword(), userDAO.getCash());
    }

    public UserDTO findUserById(Integer id) {
        UserDAO userDAO = userRepository.findOne(id);
        return mapUser(userDAO);
    }

    public Integer addNewUser(UserDTO userDTO) {
        UserDAO userDAO = userRepository.save(new UserDAO(userDTO.getUserName(), userDTO.getPassword(), userDTO.getCash()));
        return userDAO.getId();
    }


    public List<UserDAO> finadAllUsers() {
        return (List<UserDAO>) userRepository.findAll();
    }

    public Boolean checkUserNameExist(String userName) {

        UserDAO userDAO = userRepository.findByUserName(userName);
        UserDTO userDTO = mapUser(userDAO);
        return userDTO.getUserName().equals(userName);
    }
}
