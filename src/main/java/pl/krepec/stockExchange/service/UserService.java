package pl.krepec.stockExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.stockExchange.model.Market;
import pl.krepec.stockExchange.model.Operation;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.UserRepository;
import pl.krepec.stockExchange.repository.model.UserDAO;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Market market;

    private UserDTO mapUser(UserDAO userDAO) {
        return new UserDTO(userDAO.getId(), userDAO.getUserName(), userDAO.getPassword(), userDAO.getCash());
    }

    public UserDTO findUserById(Integer id) {
        UserDAO userDAO = userRepository.findOne(id);
        System.out.println(userDAO.getCash());
        UserDTO userDTO = mapUser(userDAO);
        System.out.println(userDTO.getCash());
        return userDTO;
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

    public String updateUserCash(Integer id, Double stockPrice, Double quantity, Operation operation, UserDTO userDTO) {
        UserDAO userDAO = userRepository.findOne(id);
        Double userCash = userDAO.getCash();
        Double cashAfterShopping = market.shopping(userCash, stockPrice, quantity, operation);
        userDAO.setCash(cashAfterShopping);
        UserDAO userDAOafterShopping = userRepository.save(userDAO);
        return "Actual cash is: " + userDAOafterShopping.getCash();

    }

    public Integer addNewUser(UserDTO userDTO) {
        UserDAO user = userRepository.findByUserName(userDTO.getUserName());

        try {
            boolean userExist = user.getUserName().equals(userDTO.getUserName());
            System.out.println("User name exist !!!");
            return 0;

        } catch (NullPointerException e) {

            UserDAO userDAO = userRepository.save(new UserDAO(userDTO.getUserName(), userDTO.getPassword(), userDTO.getCash()));
            System.out.println("New user added. Your ID is: " + userDAO.getId());
            return userDAO.getId();
        }


    }

}

