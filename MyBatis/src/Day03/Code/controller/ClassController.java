package Day03.Code.controller;

import Day03.Code.bean.Classes;
import Day03.Code.service.ClassService;
import Day03.Code.service.ClassServiceImpl;
import org.junit.Test;

import java.util.List;

public class ClassController {
    private ClassService classService = new ClassServiceImpl();

    @Test
    public void findAll() {
        List<Classes> classes = classService.findAll();
        for (Classes aClass : classes) {
            System.out.println(aClass);
        }
    }
}
