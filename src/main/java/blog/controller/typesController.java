package blog.controller;

import blog.entity.Types;
import blog.service.typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class typesController {

    @Autowired
    private typeService typeService;

    @GetMapping("/findAllTypes")
    public ArrayList<Types> findAllTypes(){
        return typeService.findAllTypes();
    }

    @GetMapping("/findFiveType")
    public ArrayList<Types> findFiveType(){
        return typeService.findFiveType();
    }
}
