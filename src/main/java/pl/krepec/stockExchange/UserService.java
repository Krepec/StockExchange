package pl.krepec.stockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDAO addNewUser(UserDTO userDTO) {
        UserDAO userDAO = userRepository.save(new UserDAO(userDTO.getUserName(), userDTO.getPassword(), userDTO.getCash()));
        return userDAO;

    }

    public UserDAO findUserById(Integer id) {
        UserDAO userDAO = userRepository.findOne(id);
        UserDTO userDTO = mapUser(userDAO);
        return userDAO;

    }

    public UserDTO mapUser(UserDAO userDAO) {
        UserDTO userDTO = new UserDTO(userDAO.getUserName(), userDAO.getPassword(), userDAO.getCash());
        return userDTO;
    }
}
