import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> FilaComum = new LinkedList<Integer>();
        LinkedList<Integer> FilaEspecial = new LinkedList<Integer>();

        String  opcoes[] = {"Idosos e Gravidas", "Demais Clientes", "Proximo", "Sair"};
        String  msg      = "";

        int     senha    = 1, opcao;

        do {
            msg   = "\nFila Especial: " + exibe(FilaEspecial) +
                    "\nFila Comum: "    + exibe(FilaComum) +
                    "\n\n\nSua escolha?";
            
            opcao = JOptionPane.showOptionDialog(
                        null,
                        msg,
                        "Banco Quero Seu Dinheiro",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[opcoes.length-1]);

            if      (opcao == 0) FilaEspecial.add(senha++); // insere na fila Especial
            else if (opcao == 1) FilaComum.add(senha++); // insere na fila Comum
            else if (opcao == 2) {                     // remove da fila
               if      (!FilaEspecial.isEmpty()) msg = "Senha " + FilaEspecial.remove() + " comparecer ao caixa!";
               else if (!FilaComum.isEmpty())    msg = "Senha " + FilaComum.remove() + " comparecer ao caixa!";
               else                              msg = "Nao ha clientes nas filas!";
               JOptionPane.showMessageDialog(null, msg);
            }
         } while (opcao != opcoes.length-1);

    }

    public static String exibe(LinkedList<Integer> Lista){
        String resp = "";

        //MONTA A STRING
        //for(Integer i: Lista){
        //    resp += i.toString() + " ";
        // }

        Iterator<Integer> iter1 = Lista.iterator();
		while(iter1.hasNext()){
		    resp += iter1.next() + " ";
		}

        return resp;
    }
}
