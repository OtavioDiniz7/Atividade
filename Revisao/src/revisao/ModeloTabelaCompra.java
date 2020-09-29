/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabiana
 */
public class ModeloTabelaCompra extends AbstractTableModel {
    private Vector<Produto> carrinhoCompra;
    private compraGUI painel;
    public ModeloTabelaCompra() {
        this.carrinhoCompra.size();
        this.painel = painel;
    }

    
    

    @Override
    public int getRowCount() {
        return carrinhoCompra.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto temp = carrinhoCompra.get(linha);
        switch (coluna) {
            case 0:
                return temp.getNome();
            case 1:
                return temp.getPreco();
            case 2:
                return temp.getQnt();
            case 3:
                return temp.getQnt() * temp.getPreco();
            default:
                return null;

        }
    }

    public void addNovoProduto(Produto vendido) {
        this.carrinhoCompra.add(vendido);
    }
    public void removeProdutoCarrinho(int indice) {
        this.carrinhoCompra.remove(indice);
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "Preço UNI";
            case 2:
                return "Quantidade";
            case 3:
                return "Preço parc";
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == 2) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void setValueAt(Object novoValor, int linha, int coluna) {

        if (coluna == 2) {
            
            String senha = JOptionPane.showInputDialog(null,"Informe a senha do gerente", "operaçao restrita", JOptionPane.INFORMATION_MESSAGE);
                if(senha != null && senha.equals("ifmg"))
            carrinhoCompra.get(linha).setQnt((int) novoValor);
            
            this.painel.atualizaQuantidades();

        }
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
                return String.class;
            case 1:
                return return Double.class;
            case 2:
                return return Integer.class;
            case 3:
                return return Double.class;
            default:
                return null;
        }
    }
    public Double calculaPrecoParcialCompra(){
        double  valor = 0.0;
        
        for(Produto p : carrinhoCompra){
            valor += p.getQnt() * p.getPreco();
        }
        return valor;
    }

    public Vector<Produto> produtosCarrinho() {
        return carrinhoCompra;
    }
    public void limpaCarrinho(){
        this.carrinhoCompra.clear();
    }
    
    
}
