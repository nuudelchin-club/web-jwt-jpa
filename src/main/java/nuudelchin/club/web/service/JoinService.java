package nuudelchin.club.web.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nuudelchin.club.web.dto.JoinDTO;
import nuudelchin.club.web.entity.UserEntity;
import nuudelchin.club.web.repository.UserRepository;

@Service
public class JoinService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void joinProc(JoinDTO dto) {
		
		String username = dto.getUsername();
		String password = dto.getPassword();
		
		Boolean isExist = userRepository.existsByUsername(username);
		
		if(isExist) {
			return;
		}
		
		UserEntity entity = new UserEntity();
		
		entity.setUsername(username);
		entity.setPassword(bCryptPasswordEncoder.encode(password));
		entity.setRole("ROLE_ADMIN");
		
		userRepository.save(entity);
	}
}
