package br.com.uniftec.projetoecommerce.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.uniftec.projetoecommerce.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphFragment extends Fragment {

    private View barRange_1;
    private View barRange_2;
    private View barRange_3;
    private View barRange_4;
    private View barRange_5;

    public GraphFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);

        barRange_1 = rootView.findViewById(R.id.bar_range_1);
        barRange_2 = rootView.findViewById(R.id.bar_range_2);
        barRange_3 = rootView.findViewById(R.id.bar_range_3);
        barRange_4 = rootView.findViewById(R.id.bar_range_4);
        barRange_5 = rootView.findViewById(R.id.bar_range_5);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        changeHeight(barRange_1, 130);
        changeHeight(barRange_2, 421);
        changeHeight(barRange_3, 310);
        changeHeight(barRange_4, 290);
        changeHeight(barRange_5, 390);

        super.onActivityCreated(savedInstanceState);
    }

    private void changeHeight(View barRange, int i) {
        ViewGroup.LayoutParams params = barRange.getLayoutParams();
        params.height = i;
        barRange.setLayoutParams(params);
    }

}