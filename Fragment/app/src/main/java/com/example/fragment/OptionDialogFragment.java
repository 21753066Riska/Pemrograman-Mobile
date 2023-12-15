package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionDialogFragment extends DialogFragment {

    Button btnChoose, btnClose;
    RadioGroup rgOptions;
    RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
    private OnOptionDialogListener optionDialogListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);
        rgOptions = view.findViewById(R.id.rg_option);
        rbSaf = view.findViewById(R.id.rb_saf);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbMou = view.findViewById(R.id.rb_mou);
        rbMoyes = view.findViewById(R.id.rb_moyes);

        btnChoose.setOnClickListener(v -> {
            int checkRadioButtonId = rgOptions.getCheckedRadioButtonId();
            if (checkRadioButtonId != -1) {
                String coach = null;
                if (checkRadioButtonId == R.id.rb_saf) {
                    coach = rbSaf.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_mou) {
                    coach = rbMou.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_lvg) {
                    coach = rbLvg.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_moyes) {
                    coach = rbMoyes.getText().toString().trim();
                }

                if (optionDialogListener != null) {
                    optionDialogListener.onOptionChosen(coach);
                }
                getDialog().dismiss();
            }
        });
        btnClose.setOnClickListener(v -> getDialog().cancel());
    }
    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof Detail_Category_Fragment) {
            Detail_Category_Fragment detailCategoryFragment =
                    (Detail_Category_Fragment) fragment;
            this.optionDialogListener =
                    detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }
}