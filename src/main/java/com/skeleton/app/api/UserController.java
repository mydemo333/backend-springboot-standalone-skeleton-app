package com.skeleton.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.app.domain.User;
import com.skeleton.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(this.userService.createUser(user));
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateProduct(@RequestParam(value = "id") long id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.updateUser(user));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	@GetMapping("/get")
	public ResponseEntity<User> getProductById(@RequestParam(value = "id") long id) {
		return ResponseEntity.ok().body(userService.getUserById(id));
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteProduct(@RequestParam(value = "id") long id) {
		this.userService.deleteUser(id);
		return HttpStatus.OK;
	}
}
