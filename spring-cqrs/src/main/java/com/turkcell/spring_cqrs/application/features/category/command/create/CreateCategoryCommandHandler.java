package com.turkcell.spring_cqrs.application.features.category.command.create;

import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.application.features.category.mapper.CategoryMapper;
import com.turkcell.spring_cqrs.application.features.category.rule.CategoryBusinessRules;
import com.turkcell.spring_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.spring_cqrs.domain.Category;
import com.turkcell.spring_cqrs.persistence.repository.CategoryRepository;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, CreatedCategoryResponse> 
{
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final CategoryMapper categoryMapper;


    public CreateCategoryCommandHandler(CategoryRepository categoryRepository,
            CategoryBusinessRules categoryBusinessRules, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CreatedCategoryResponse handle(CreateCategoryCommand command) 
    {
        categoryBusinessRules.categoryWithSameNameMustNotExist(command.name()); // rules

        Category category = categoryMapper.categoryFromCreateCommand(command); // mapping

        categoryRepository.save(category); // repo

        return categoryMapper.createdCategoryResponseFromCategory(category); // mapping
    }
}
