package dh.tfi.integrador.service;

import dh.tfi.integrador.entities.AppUser;
import dh.tfi.integrador.entities.AppUsuarioRoles;
import dh.tfi.integrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments arguments)throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordUser = passwordEncoder.encode("digital");
        String passwordAdmin = passwordEncoder.encode("ctd");

        userRepository.save(new AppUser("Martin", "martinperez", "martinperez@gmail.com", passwordUser, AppUsuarioRoles.USER));
        userRepository.save(new AppUser("Vane", "vanevilte", "vanevilte@gmail.com", passwordAdmin, AppUsuarioRoles.ADMIN));

    }
}
