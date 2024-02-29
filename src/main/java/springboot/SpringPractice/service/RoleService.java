package springboot.SpringPractice.service;

import org.springframework.stereotype.Service;
import springboot.SpringPractice.DAO.RoleRepository;
import springboot.SpringPractice.entity.Role;
import springboot.SpringPractice.entity.TodoEntity;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role save(String role) {
        Role newRole = Role.builder()
                .name(role)
                .build();
        roleRepository.save(newRole);
        return newRole;
    }

    public List<Role> findByName(String name){
        return roleRepository.findByName(name);
    }
}
