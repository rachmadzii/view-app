package com.example.viewapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewapp.adapter.Data;
import com.example.viewapp.R;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    List<String> menuTitle;
    List<Integer> image;
    private RecyclerView recyclerView;
    private Data.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        menuTitle = new ArrayList<>();
        image = new ArrayList<>();

        menuTitle.add("Coding");
        menuTitle.add("Challenge");
        menuTitle.add("Learning");
        menuTitle.add("Quiz");

        image.add(R.drawable.code);
        image.add(R.drawable.challenge);
        image.add(R.drawable.learn);
        image.add(R.drawable.quiz);

        adapter = new Data.Adapter(getContext(),menuTitle,image);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}