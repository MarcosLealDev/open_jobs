package com.marcos.open_jobs.modules.company.controllers;

import com.marcos.open_jobs.exceptions.UserFoundException;
import com.marcos.open_jobs.modules.company.entities.CompanyEntity;
import com.marcos.open_jobs.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch(Exception e) {
                e.printStackTrace();
               return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
