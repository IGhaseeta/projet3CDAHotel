package com.eql.Hotel.services;

import com.eql.Hotel.dto.UserDto;
import com.eql.Hotel.models.Role;
import com.eql.Hotel.models.User;
import com.eql.Hotel.repository.RoleRepository;
import com.eql.Hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName()+ "," + userDto.getLastName()); //Ici on concataine le nom et le prénom pour avoir le mapping dans la base de données
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));// ici il faut scripté la clé car sinon le password est en blanc dans la base

        user.setAdresse(userDto.getLineAdresse()+ "," + userDto.getZipCode()+","+ userDto.getCity());

        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null)
        {
            role = checkRoleUserExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto mappingUser(User user) {
        return mapToUserDTO(user);
    }

    private Role checkRoleUserExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream() // filtre pour savoir si je garde ou je jette
                .map(user -> mapToUserDTO(user)) // transforme un objet en un autre
                .collect(Collectors.toList());  // regroupe le tout  "collection le resultat"
    }


    private UserDto mapToUserDTO(User user){

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());

        String[] str = user.getName().split(",");           //ici on redécoupe le nom en entier issue de  la base de donneés
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);

        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());

        String[] adr = user.getAdresse().split(",");
        userDto.setLineAdresse(adr[0]);
        userDto.setZipCode(adr[1]);
        userDto.setCity(adr[2]);

        return userDto;
    }


}
