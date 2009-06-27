package com.dudhoo.nemesis.component;

import com.dudhoo.nemesis.component.event.FindPessoaListAdapter;
import com.dudhoo.nemesis.component.event.FindProdutoListAdapter;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.swing.StartFrame;

import java.text.NumberFormat;

import javax.swing.JTextField;

public class BotaoFindProduto extends BotaoFind {
    private Produto produto;
    private JTextField holder;

    public BotaoFindProduto() {
        this.botaoProcurar.addActionListener(new FindProdutoListAdapter(StartFrame.getCurrentInstance(), 
                                                                        true, 
                                                                        this));
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if (produto != null) {
            this.textField.setText(produto.getNome());
            if (this.holder != null) {

                this.holder.setText(NumberFormat.getCurrencyInstance().format(produto.getPrecoVenda()));
            }
        } else {
            this.textField.setText(null);
        }
    }

    /**Seta o text que será atualizado automaticamente cada vez que for escolhido um produto
     * */
    public void setPrecoHolder(JTextField _holder) {
        holder = _holder;
    }

    public Produto getProduto() {
        return produto;
    }
}
