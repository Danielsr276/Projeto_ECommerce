package br.com.uniftec.projetoecommerce.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.uniftec.projetoecommerce.R;

/**
 * Created by daniel on 08/11/17.
 */

public class CarrinhoComprasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView descricaoProdutoCarrinho;
    public ImageView imagemProdutoCarrinho;
    public TextView quantidadeProdutoCarrinho;
    public TextView precoProdutoCarrinho;
    public ImageView taskDeleteCarrinho;
    public Button btnIncrementQuantidade;
    public Button btnDecrementQuantidade;

    public CarrinhoComprasViewHolder(View itemView) {
        super(itemView);

        descricaoProdutoCarrinho = itemView.findViewById(R.id.descricao_produto_carrinho);
        imagemProdutoCarrinho = itemView.findViewById(R.id.imagem_produto_carrinho_compras);
        quantidadeProdutoCarrinho = itemView.findViewById(R.id.quantidade_produto_carrinho);
        quantidadeProdutoCarrinho.setText(String.valueOf(0));
        precoProdutoCarrinho = itemView.findViewById(R.id.preco_produto_carrinho);
        taskDeleteCarrinho = itemView.findViewById(R.id.task_delete_carrinho);

        btnIncrementQuantidade = itemView.findViewById(R.id.increment_carrinho);
        btnDecrementQuantidade = itemView.findViewById(R.id.decrement_carrinho);

        btnDecrementQuantidade.setOnClickListener(this);
        btnIncrementQuantidade.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnIncrementQuantidade) {

            CharSequence text = quantidadeProdutoCarrinho.getText();
            int i = Integer.parseInt(text.toString());
            quantidadeProdutoCarrinho.setText(String.valueOf(i + 1));

        } else if (view == btnDecrementQuantidade) {
            CharSequence text = quantidadeProdutoCarrinho.getText();
            int i = Integer.parseInt(text.toString());
            if (i > 0) {
                quantidadeProdutoCarrinho.setText(String.valueOf(i - 1));
            }

        }
    }
}
