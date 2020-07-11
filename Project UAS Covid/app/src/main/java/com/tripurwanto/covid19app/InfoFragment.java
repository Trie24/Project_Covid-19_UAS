package com.tripurwanto.covid19app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends Fragment {

    @BindView(R.id.info_language_button)
    LinearLayout mLanguage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this, view);

        mLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLanguageDialog();
            }
        });

        return view;
    }

    private void showLanguageDialog() {
        final String[] listLanguage = {"Indonesia", "English"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Choose Language...");
        builder.setSingleChoiceItems(listLanguage, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("in");
                    getActivity().finish();
                    startActivity(getActivity().getIntent());
                } else if (i == 1){
                    setLocale("en");
                    getActivity().finish();
                    startActivity(getActivity().getIntent());
                }

                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        Objects.requireNonNull(this.getActivity()).getBaseContext().getResources().updateConfiguration(configuration, getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        editor.putString("language", lang);
        editor.apply();
    }

}
