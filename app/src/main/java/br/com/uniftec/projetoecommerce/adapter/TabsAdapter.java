package br.com.uniftec.projetoecommerce.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.uniftec.projetoecommerce.ui.fragment.GraphFragment;
import br.com.uniftec.projetoecommerce.ui.fragment.ListPedidosFragment;
import br.com.uniftec.projetoecommerce.ui.fragment.ListProdutosFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ListProdutosFragment();
            case 1:
                return new GraphFragment();
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
