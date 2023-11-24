package com.example.springboot.seviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.EmailAlreadyExistsException;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.mapper.AutoUserMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.sevice.UserService;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;


	
	@Override
	public UserDto createUser(UserDto userDto) {
		
//		User user = UserMapper.mapToUser(userDto);
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists for User");
		}
		
		User user = modelMapper.map(userDto,User.class);
		
//		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		
		User savedUser = userRepository.save(user);
		
//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		
//		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		
		return savedUserDto;
	}
	
	@Override
	public UserDto getUserById(Long userId) {
	User user = userRepository.findById(userId).orElseThrow(
			()->new ResourceNotFoundException("User", "id", userId));
//	User user= optionalUser;
//	return UserMapper.mapToUserDto(user);
	return modelMapper.map(user, UserDto.class);
//	return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user)-> modelMapper.map(users, UserDto.class))
				.collect(Collectors.toList());
//		 return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
//	                .collect(Collectors.toList());
	}

	@Override
	public void deleteUser(long userId) {
		User existingUser = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", userId));
		userRepository.deleteById(userId);
		
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDto(updatedUser);
       return modelMapper.map(updatedUser, UserDto.class);
//        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	


}
