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


    public List<UserDAO> finadAllUsers() {
        return (List<UserDAO>) userRepository.findAll();
    }

    public Boolean checkUserNameExist(String userName) {
        UserDAO userDAO = userRepository.findByUserName(userName);
        UserDTO userDTO = mapUser(userDAO);

        return userDTO.getUserName().equals(userName);
    }

    public UserDTO findByUserNameAndPassword(String userName, String password) {

        UserDAO userDAO = userRepository.findByUserNameAndPassword(userName, password);
        if (userDAO.getUserName().equals(userName) & userDAO.getPassword().equals(password)) {
            mapUser(userDAO);
            return mapUser(userDAO);
        } else System.out.println("Login failed, check user name and password");
        return null;
    }

    public Integer addNewUser(UserDTO userDTO) {
        UserDAO user = userRepository.findByUserName(userDTO.getUserName());
        if (user.getUserName().equals(userDTO.getUserName())){
            return 0;
        }
        else {
            UserDAO userDAO = userRepository.save(new UserDAO(userDTO.getUserName(), userDTO.getPassword(), userDTO.getCash()));
            System.out.println(userDAO);

            return userDAO.getId();
        }

    }

}

