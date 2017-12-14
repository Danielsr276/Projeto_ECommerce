package br.com.uniftec.projetoecommerce.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.io.Serializable;

import br.com.uniftec.projetoecommerce.ui.fragment.GraphFragment;
import br.com.uniftec.projetoecommerce.ui.fragment.ListPedidosFragment;
import br.com.uniftec.projetoecommerce.ui.fragment.ListProdutosFragment;

public class TabsAdapter extends FragmentPagerAdapter implements Serializable{

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }
    private ListProdutosFragment listProdutosFragment;

    @Override
    public Fragment getItem(int position) {
        Bundle bundle;

        switch (position) {
            case 0:
                listProdutosFragment = new ListProdutosFragment();
                return listProdutosFragment;
            case 1:
                GraphFragment graphFragment = new GraphFragment();
                bundle = new Bundle();
                bundle.putSerializable(GraphFragment.PRODUCT_PARAMETER, listProdutosFragment);
                graphFragment.setArguments(bundle);
                return graphFragment;
            case 2:
                return new ListPedidosFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Produtos";
            case 1:
                return "Gráfico de preços";
            case 2:
                return "Meus Pedidos";
        }
        return null;
    }

}
