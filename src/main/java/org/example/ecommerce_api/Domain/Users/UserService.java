package org.example.ecommerce_api.Domain.Users;

import org.example.ecommerce_api.Domain.Users.Validations.ValidUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private List<ValidUser> validUsers;

    public DataListUser save(DataRegisterUser data){
        validUsers.forEach(validUser -> validUser.validateRegister(data));
        User user = new User(data);
        userRepository.save(user);
        return new DataListUser(user);
    }

    public DataListUser login(DataLoginUser data){
        Optional<User> user = userRepository.validLogin(data.email(), data.password());
        if(user.isEmpty()){
            throw new RuntimeException("Invalid email or password");
        }
        return new DataListUser(user.get());
    }

    public DataListUser update(DataUpdateUser data) {
        User existingUser = userRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        validUsers.forEach(validUser -> validUser.validUpdate(data));

        existingUser.update(data);

        userRepository.save(existingUser);
        return new DataListUser(existingUser);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    public DataListUser findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new DataListUser(user);
    }

    public List<DataListUser> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(DataListUser::new).toList();
    }
}
