package com.example.islandbuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class selector_Fragment extends Fragment {

    private static RecyclerView selectorRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector,container,false);
        selectorRecyclerView = view.findViewById(R.id.selectorRecyclerView);
        selectorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false)); //how it laid out //rv set layout manager

        //set data
        StructureData newListData = new StructureData();
        List<Structure> structureList = newListData.getStructureList();
        SelectorList adapter = new SelectorList(getActivity(),structureList);

        selectorRecyclerView.setAdapter(adapter);// rv set adapter


        return view;
    }
}
