package com.shotmk.el.services;

import com.shotmk.el.entity.Tag;

public interface TagService {

    public Tag addTag(Tag tag);

    public Tag getTag(int id);

    public Tag getTagByTagstring(String tag);

}
