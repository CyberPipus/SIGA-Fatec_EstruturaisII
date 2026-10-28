package siga;

public class ComMarcaDAgua extends DecoradorRelatorio {
    public ComMarcaDAgua(Relatorio interno) {
        super(interno);
    }

    @Override
    public String gerar() {
        return interno.gerar()+"\n*** RASCUNHO — NAO E DOCUMENTO OFICIAL ***";
    }
}
