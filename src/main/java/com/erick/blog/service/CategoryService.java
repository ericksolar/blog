package com.erick.blog.service;

import com.erick.blog.repository.CategoryRepository;
import com.erick.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository userRepository;

}
