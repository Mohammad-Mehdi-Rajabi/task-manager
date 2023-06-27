package com.taskmaneger.demo.web.controller;


import com.taskmaneger.demo.web.dto.FinancialDetailDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.FinancialDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financialDetail/")
@CrossOrigin
public class FinancialDetailController {

    private FinancialDetailService financialDetailService;

    @Autowired
    public FinancialDetailController(FinancialDetailService financialDetailService) {
        this.financialDetailService = financialDetailService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        Response<?> all = financialDetailService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/addFinancialDetail")
    public ResponseEntity<?> addFinancialDetail(@RequestBody FinancialDetailDto financialDetailDto) {
        Response<?> response = financialDetailService.addFinancialDetail(financialDetailDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getFinancialDetailById/{id}")
    public ResponseEntity<?> getFinancialDetailById(@PathVariable long id) {
        Response<?> response = financialDetailService.getFinancialDetailById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFinancialDetailById/{id}")
    public ResponseEntity<?> deleteFinancialDetailById(@PathVariable long id) {
        Response<?> response = financialDetailService.deleteByID(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
