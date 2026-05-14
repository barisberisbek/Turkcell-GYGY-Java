package com.turkcell.spring_cqrs.application.features.category.mapper;

import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.spring_cqrs.application.features.category.command.create.CreatedCategoryResponse;
import com.turkcell.spring_cqrs.domain.Category;

@Component
public class CategoryMapper {
    public Category categoryFromCreateCommand(CreateCategoryCommand command)
    {
        Category category = new Category();
        category.setName(command.name());
        return category;
    }
    public CreatedCategoryResponse createdCategoryResponseFromCategory(Category category)
    {
        return new CreatedCategoryResponse(category.getId(),category.getName());
    }
}
