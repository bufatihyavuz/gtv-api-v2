package org.gtvapi.service;

import org.gtvapi.dto.responsedto.CategoryResponseDTO;
import org.gtvapi.entity.Category;
import org.gtvapi.mapper.CategoryMapper;
import org.gtvapi.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;


    public CategoryService(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponseDTO> getAllCategories(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryMapper.toResponseDTOList(categoryList);
    }

}
