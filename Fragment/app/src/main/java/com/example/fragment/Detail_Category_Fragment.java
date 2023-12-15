package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Detail_Category_Fragment extends Fragment implements Detail_Category_Fragmentt {

    public OptionDialogFragment.OnOptionDialogListener optionDialogListener;
    TextView tvCategoryName;
    TextView tvCategoryDescription;
    Button btnShowProfile;
    Button btnShowDialog;
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";

    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = this.description;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable
                             Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnShowProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);

        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
        
        btnShowDialog.setOnClickListener(v -> {
            optionDialogFragment mOptionalDialogFragment = new optionDialogFragment();

            FragmentManager mFragmentManager = getChildFragmentManager();
            mOptionalDialogFragment. show(mFragmentManager, OptionDialogFragment.class.getSimpleName());

            btnShowProfile.setOnClickListener(view1 -> {
                Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(mIntent);
            });
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail__category_, container, false);
    }

    private class optionDialogFragment {
        public void show(FragmentManager mFragmentManager, String simpleName) {
        }
    }

    @Override
    public void onOptionChosen(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}