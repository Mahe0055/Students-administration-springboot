package com.example.studentsadministration.Config;

import com.example.studentsadministration.Models.Courses;
import com.example.studentsadministration.Models.Students;
import com.example.studentsadministration.Repositories.ICourseRepository;
import com.example.studentsadministration.Repositories.IStudentRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {

    IStudentRepository studentrepo;
    ICourseRepository courserepo;

    public DeveloperData(IStudentRepository studentrepo, ICourseRepository courserepo) {
        this.studentrepo = studentrepo;
        this.courserepo = courserepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.studentrepo.save(new Students("John"));
        this.studentrepo.save(new Students("Emily"));
        this.studentrepo.save(new Students("Michael"));
        this.studentrepo.save(new Students("Michael"));
        this.studentrepo.save(new Students("Alice"));
        this.studentrepo.save(new Students("James"));
        this.studentrepo.save(new Students("Sophia"));


        this.courserepo.save(new Courses("Math"));
        this.courserepo.save(new Courses("Latin"));
        this.courserepo.save(new Courses("History"));
        this.courserepo.save(new Courses("Physical education"));
        this.courserepo.save(new Courses("Drama"));
    }


}
