package util;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro404(MethodArgumentNotValidException ex) {
        var erros =ex.getFieldErrors();
        var lista = erros.stream().map(DadosErroValicao::new).toList();

        return ResponseEntity.badRequest().body(lista);
    }
    private record DadosErroValicao(String campo,String msnErro){
        public DadosErroValicao(FieldError erro){
            this(erro.getField(),erro.getDefaultMessage());;
        }
    }
}
