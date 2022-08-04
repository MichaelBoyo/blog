package com.boyo.blog.data.repositories;

import com.boyo.blog.data.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
