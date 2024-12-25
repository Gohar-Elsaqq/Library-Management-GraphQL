package com.example.demo.controoler;


import com.example.demo.entity.Patron;
import com.example.demo.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PatronController {
    @Autowired
    private PatronRepository patronRepository;

    @QueryMapping
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @QueryMapping
    public Patron getPatronById(@Argument Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Patron addPatron(@Argument String name, @Argument String contactInformation) {
        Patron patron = new Patron(name, contactInformation);
        return patronRepository.save(patron);
    }
}