package test.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Suyash on 09-05-2017.
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping(value="/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student create(@RequestBody Student stu){
        studentDao.save(stu);
        return stu;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public Iterable<Student> getAll(){
        return studentDao.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Student getById(@PathVariable(name = "id", required = true) Long id){
        return studentDao.findOne(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student update(@PathVariable(name = "id", required = true) Long id, @RequestBody Student stu){
        Student s = studentDao.findOne(id);
        stu.setId(s.getId());
        studentDao.save(stu);
        return stu;
    }
}
