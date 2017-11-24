package br.com.uniftec.projetoecommerce.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import br.com.uniftec.projetoecommerce.R;
import br.com.uniftec.projetoecommerce.adapter.TabsAdapter;
import br.com.uniftec.projetoecommerce.database.DataSource;
import br.com.uniftec.projetoecommerce.model.Usuario;
import br.com.uniftec.projetoecommerce.ui.fragment.ListPedidosFragment;

public class ListProdutosActivity extends AppCompatActivity {

    private TabsAdapter mTabsAdapter;

    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produtos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mTabsAdapter);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_produto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_carrinho_compras:
                startActivity(new Intent(this, CarrinhoComprasActivity.class));

                return true;

            case R.id.menu_cliente:
                List<Usuario> usuarios = DataSource.carregarJsonTestes(this);
                Intent intent = new Intent(this, UserActivity.class);
                intent.putExtra(UserActivity.USER_PARAMETER, usuarios.get(0));
                startActivity(intent);

                return true;
            case R.id.menu_pedidos:

                startActivity(new Intent(this, CarrinhoComprasActivity.class));
//                List<Usuario> usuarios2 = DataSource.carregarJsonTestes(this);
//                Intent intent2 = new Intent(this, UserActivity.class);
//                intent2.putExtra(UserActivity.USER_PARAMETER, usuarios2.get(0));
//                startActivity(intent2);

                return true;
            default:
                return true;
        }
    }


}
