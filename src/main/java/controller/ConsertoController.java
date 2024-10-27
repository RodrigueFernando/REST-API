package controller;

import conserto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
    public void cadastrar(@RequestBody  DadosCadastro dados) {

       // System.out.println(json);
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public List<Conserto> listar() {

        return repository.findAll();
    }

    @GetMapping("algunsdados")
    public List<DadosListagemConsertos> listarAlgunsDados() {
        return repository.findAll().stream().map(DadosListagemConsertos::new).toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {

        Optional<Conserto> medicoOptional = repository.findById(id);

        if (medicoOptional.isPresent()) {
            Conserto conserto = medicoOptional.get();
            return ResponseEntity.ok(conserto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {

       Conserto conserto = repository.getReferenceById( dados.id() );
      conserto.atualizarInformacoes(dados);


    }



}

