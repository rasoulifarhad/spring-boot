package com.farhad.example.cms.domain.vo;

import java.util.HashSet;
import java.util.Set;

import com.farhad.example.cms.domain.models.Category;
import com.farhad.example.cms.domain.models.Tag;

import lombok.Data;

@Data
public class NewsRequest {
	
	private String title;
	private String content;
	Set<Category> categories = new HashSet<>();
	Set<Tag> tags = new HashSet<>();

}
