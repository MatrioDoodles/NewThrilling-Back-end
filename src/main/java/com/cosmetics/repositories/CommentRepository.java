package com.cosmetics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	public List<Comment> findByproduct_idAndApprouvedTrue(long id);
	public List<Comment> findByapprouvedFalse();
}
