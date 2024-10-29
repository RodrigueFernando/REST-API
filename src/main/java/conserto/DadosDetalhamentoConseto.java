package conserto;

public record DadosDetalhamentoConseto(Long id, String dataSaida, String dataEntrada, String anoExperiencia, String nome,
                                       String ano, String marca , String modelo , String  cor ) {

    public DadosDetalhamentoConseto(Conserto conserto) {

        this( conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida() , conserto.getMecanico().getAnosExperiencia(),conserto.getMecanico().getNome()
                ,conserto.getVeiculo().getAno(),conserto.getVeiculo().getMarca(),conserto.getVeiculo().getModelo(),conserto.getCor()

               );
    }
}
