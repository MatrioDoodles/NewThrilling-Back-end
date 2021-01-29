package com.cosmetics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.models.Comment;
import com.cosmetics.repositories.CommentRepository;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/comments")
public class CommentController {

	@Autowired
	private CommentRepository CommentRepository;
	
	@GetMapping("/GetAllComments")
	public List<Comment> GetAllComments()
	{
		return CommentRepository.findAll();
	}
	
	@GetMapping("/GetAllCommentsByProductApprouved/{id}")
	public List<Comment> GetAllCommentsByProductApprouved(@PathVariable long id)
	{
		return CommentRepository.findByproduct_idAndApprouvedTrue(id);
	}
	@GetMapping("/GetAllCommentsNoneApprouved")
	public List<Comment> GetAllCommentsNoneApprouved()
	{
		return CommentRepository.findByapprouvedFalse();
	}
	
	@PostMapping("/addComment")
	public com.cosmetics.models.Comment addComment(@RequestBody Comment Comment) {
		
		return CommentRepository.save(Comment);
	}
	@PutMapping("/ModComment")
	public Comment ModComment(@RequestBody Comment Comment) {
		
		return CommentRepository.save(Comment);
	}
	@GetMapping("/{id}")
	public Comment GetCommentByid(@PathVariable long id) {
		return CommentRepository.findById(id).get();
	}

	@DeleteMapping("/DelComment/{Comment}")
	public void DelAscenseur(@PathVariable long Comment) {
		
		CommentRepository.deleteById(Comment);
			//return "Categorie Supprimé";
	}
}
