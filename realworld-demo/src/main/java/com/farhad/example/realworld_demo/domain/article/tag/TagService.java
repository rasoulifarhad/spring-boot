package com.farhad.example.realworld_demo.domain.article.tag;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    @Transactional(readOnly = true)
    public Set<Tag> findAll() {
        return new HashSet<>(tagRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Tag> findVyValue(String value) {
        return tagRepository.findFirstByValue(value);
    }

    @Transactional(readOnly = true)
    public Set<Tag> reloadAllTagsIfAlreadyPresent(Set<Tag> tags) {
        return tags.stream()
            .map(tag -> findVyValue(valueOf(tag)).orElse(tag))
            .collect(toSet());
    }
}
