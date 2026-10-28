package siga;

public class Main{

    public static void main(String[] args){
        System.out.println("=== SIGA - Aula 11: Decorator e Composite (codigo inicial) ===");

        System.out.println();
        System.out.println("1) Relatorios: uma subclasse por combinacao");
        Relatorio[] variantes={
            new RelatorioDeAlunos(),
            new ComCabecalho(new RelatorioDeAlunos()),
            new ComMarcaDAgua(new RelatorioDeAlunos()),
            new ComNumeracao(new RelatorioDeAlunos()),
            new ComCabecalho(new ComMarcaDAgua(new RelatorioDeAlunos())),
            new ComCabecalho(new ComNumeracao(new RelatorioDeAlunos())),
            new ComMarcaDAgua(new ComNumeracao(new RelatorioDeAlunos())),
            new ComCabecalho(new ComMarcaDAgua(new ComNumeracao(new RelatorioDeAlunos())))
        };
        for (Relatorio r : variantes){
            System.out.println("   --- " + r.getClass().getSimpleName() + " ---");
            for (String linha : r.gerar().split("\n")) {
                System.out.println("   " + linha);
            }
        }

        System.out.println();
        System.out.println("2) Composite: Modulo e Disciplina");
        Modulo curso = new Modulo("DSM - Desenvolvimento de Software Multiplataforma");

        Modulo primeiro = new Modulo("1o semestre");
        primeiro.adicionar(new Disciplina("Algoritmos", 80));
        primeiro.adicionar(new Disciplina("Banco de Dados I", 60));

        Modulo segundo = new Modulo("2o semestre");
        segundo.adicionar(new Disciplina("Tecnicas de Programacao II", 80));
        segundo.adicionar(new Disciplina("Desenvolvimento Web II", 80));

        curso.adicionar(primeiro);
        curso.adicionar(segundo);
        curso.adicionar(new Disciplina("Projeto Integrador", 40));

        System.out.println("   Carga total: " + curso.getCargaHoraria() + "h");
        curso.imprimir(0);
    }
}
