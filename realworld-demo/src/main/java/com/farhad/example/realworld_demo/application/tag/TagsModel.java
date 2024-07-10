package com.farhad.example.realworld_demo.application.tag;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TagsModel {

    private final Set<String> tags;
}
