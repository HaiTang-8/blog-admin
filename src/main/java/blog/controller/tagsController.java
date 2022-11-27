package blog.controller;

import blog.entity.Tags;
import blog.service.tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class tagsController {

    @Autowired
    private tagService tagService;

    @GetMapping("/findAllTags")
    public ArrayList<Tags> findAllTags(){

        return tagService.findAllTags();
    }

    @GetMapping("/findFiveTags")
    public ArrayList<Tags> findFiveTags(){
        return tagService.findFiveTags();
    }
}
