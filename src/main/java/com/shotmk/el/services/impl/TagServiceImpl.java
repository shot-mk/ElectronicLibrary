package com.shotmk.el.services.impl;

import com.shotmk.el.entity.Tag;
import com.shotmk.el.repository.TagRepository;
import com.shotmk.el.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag addTag(Tag tag) {
        Tag newTag = tagRepository.saveAndFlush(tag);
        return newTag;
    }

    @Override
    public Tag getTag(int id) {
        return tagRepository.findOne(id);
    }


    @Override
    public Tag getTagByTagstring(String tag) {
        return tagRepository.getTagByTagstring(tag);
    }
}
