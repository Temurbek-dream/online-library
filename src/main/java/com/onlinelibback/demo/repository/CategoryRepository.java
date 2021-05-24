package com.onlinelibback.demo.repository;

import com.onlinelibback.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>
{

}
