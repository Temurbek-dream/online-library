package com.onlinelibback.demo.repository;

import com.onlinelibback.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long>
{

}
