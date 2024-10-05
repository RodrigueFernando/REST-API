package controller;

import conserto.Conserto;
import conserto.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;


import conserto.DadosCadastro;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "conserto")
@EntityScan(basePackages = "conserto")

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastro dados) {

       // System.out.println(json);
        repository.save(new Conserto(dados));
    }
}

