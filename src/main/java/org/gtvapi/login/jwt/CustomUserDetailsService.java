package org.gtvapi.login.jwt;

import org.gtvapi.entity.User;
import org.gtvapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // UserRepository'inizi buraya inject edin

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kullanıcıyı veritabanından alıyoruz
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));

        // Burada, veritabanındaki kullanıcı bilgilerini dönüyoruz
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Şifreyi doğru şekilde alıyoruz
                //.roles(user.getRoles()) // Kullanıcının rollerini de burada belirtmelisiniz
                .build();
    }
}
