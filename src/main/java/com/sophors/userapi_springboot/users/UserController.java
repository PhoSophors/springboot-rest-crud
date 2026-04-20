package com.sophors.userapi_springboot.users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sophors.userapi_springboot.response.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    };

    // Create user
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return service.createUser(user);
    };

    // List all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserModel>>> getAllUsers() {
        List<UserModel> users = service.getAllUsers();
        return ResponseEntity.ok(
            new ApiResponse<>(
                "Success",
                200,
                "Users fetched successfully",
                users
            )
        );
    };

    // Get user by id
   @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserModel>> getUserById(@PathVariable Long id) {
        UserModel user = service.getUserById(id);
        return ResponseEntity.ok(
            new ApiResponse<>(
                "Success",
                200,
                "User fetched successfully",
                user
            )
        );
    };

    // Delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserModel>> deleteUserById(@PathVariable long id) {
        service.deleteUserById(id);
        return ResponseEntity.ok(
            new ApiResponse<>(
                "Success",
                200,
                "User deleted successfully",
                null
            )
        );
    };

     // Update user by id
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserModel>> updateUserById(@PathVariable Long id, @RequestBody UserModel updatedUser) {
        UserModel user = service.updateUserById(id, updatedUser);
        return ResponseEntity.ok(
            new ApiResponse<>(
                "Success",
                200,
                "User updated successfully",
                user
            )
        );
    };

    public static class StatusUpdateRequest {
        private UserModel.Status status;
        public UserModel.Status getStatus() { return status; }
        public void setStatus(UserModel.Status status) { this.status = status; }
    }

    // Update user status by id
    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse<UserModel>> updateUserStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateRequest request) {
        UserModel user = service.updateUserStatus(id, request.getStatus());
        return ResponseEntity.ok(
            new ApiResponse<>("Success", 200, "User status updated successfully", user)
        );
    };

}