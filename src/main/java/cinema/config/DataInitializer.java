package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {
    private Role adminRole = new Role(Role.RoleName.ADMIN);
    private Role userRole = new Role(Role.RoleName.USER);
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        roleService.add(new Role(Role.RoleName.ADMIN));
        roleService.add(new Role(Role.RoleName.USER));
        User admin = new User();
        admin.setEmail("admin2022@i.ua");
        admin.setPassword("admin2022");
        admin.setRoles(Set.of(adminRole));
        User user = new User();
        user.setEmail("user2022@gmail.com");
        user.setPassword("user2022");
        user.setRoles(Set.of(userRole));
        userService.add(admin);
        userService.add(user);
    }
}
