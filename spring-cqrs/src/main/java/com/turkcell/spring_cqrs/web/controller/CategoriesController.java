package com.turkcell.spring_cqrs.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.spring_cqrs.application.features.category.command.create.CreatedCategoryResponse;
import com.turkcell.spring_cqrs.application.features.category.query.getall.GetAllCategoriesQuery;
import com.turkcell.spring_cqrs.application.features.category.query.getall.GetAllCategoriesResponse;
import com.turkcell.spring_cqrs.core.mediator.Mediator;

@RequestMapping("/api/categories")
@RestController
public class CategoriesController {
    private final Mediator mediator;

    public CategoriesController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public CreatedCategoryResponse create(@RequestBody CreateCategoryCommand command){
        return mediator.send(command);
    }

    @GetMapping
    public Page<GetAllCategoriesResponse> getAll(
        @RequestParam(defaultValue="0") int pageNumber,
        @RequestParam(defaultValue="10") int pageSize
    ) {
        var query = new GetAllCategoriesQuery(pageNumber, pageSize);

        return mediator.send(query);
    }
}
