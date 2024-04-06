package com.scalableservices.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scalableservices.dto.ItemDTO;
import com.scalableservices.service.ItemService;

@RequestMapping("/items")
@RestControllerAdvice
@RestController
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<ItemDTO> all() {
		return itemService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public ItemDTO get(@PathVariable long id) {
		return itemService.get(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public ItemDTO put(@PathVariable long id, @RequestBody ItemDTO itemDTO) {
		itemDTO.setId(id);
		return itemService.save(itemDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		itemService.delete(id);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemDTO add(@RequestBody ItemDTO itemDTO) {
		return itemService.save(itemDTO);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Throwable ex) {
		// Add conditional logic to show differnt status on different exceptions
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
