package com.sophors.userapi_springboot.users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Crete user
    public UserModel createUser(UserModel user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        return repo.save(user);
    };

    // List all users
    public List<UserModel> getAllUsers() {
        return repo.findAll();
    };

    // Get user by id
    public UserModel getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    };

    // Update user by id
    public UserModel updateUserById(Long id, UserModel updatedUser) {
        UserModel user = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update all fields
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setAddress(updatedUser.getAddress());
        user.setStatus(updatedUser.getStatus());
        user.setAvatar(updatedUser.getAvatar());

        return repo.save(user);
    }


    // Update user status
    public UserModel updateUserStatus(Long id, UserModel.Status status) {
        UserModel user = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setStatus(status);
        return repo.save(user);
    };
    
    // delete user by id
    public void deleteUserById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        repo.deleteById(id);
    };

}