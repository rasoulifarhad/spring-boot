package com.farhad.example.realworld_demo.application.tag;

import static java.util.stream.Collectors.toSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.realworld_demo.domain.article.tag.TagService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/tags")
@RestController
@RequiredArgsConstructor
public class TagRestController {

    private final TagService tagService;

    @GetMapping
    public TagsModel getTags() {
        return new TagsModel(
            tagService.findAll().stream()
                .map(Object::toString)
                .collect(toSet()));
    }
    
}
