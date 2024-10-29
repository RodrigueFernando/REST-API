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
import org.springframework.web.util.UriComponentsBuilder;


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
    public ResponseEntity  cadastrar(@RequestBody @Valid DadosCadastro dados, UriComponentsBuilder uriBuilder) {

       // System.out.println(json);
        var conserto = new Conserto(dados);

        repository.save(conserto);

        // Gerar automaticamente a URL para o novo recurso criado:
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        // Vamos aqui usar o DTO que criamos para o método atualizar:
        return ResponseEntity.created(uri).body( new DadosDetalhamentoConseto(conserto) );
    }

    @GetMapping
    public List<Conserto> listar() {

        return repository.findAll();
    }

    @GetMapping("algunsdados")
    public List<DadosListagemConsertos> listarAlgunsDados() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemConsertos::new).toList();

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
    public ResponseEntity<DadosDetalhamentoConseto> atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {

       Conserto conserto = repository.getReferenceById( dados.id() );
      conserto.atualizarInformacoes(dados);

       return ResponseEntity.ok( new DadosDetalhamentoConseto(conserto) );
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        Conserto conserto = repository.getReferenceById(id);

       conserto.excluir();

        return ResponseEntity.noContent().build();
    }


}

