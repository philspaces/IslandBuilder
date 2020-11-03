package com.example.islandbuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class map_Fragment extends Fragment {
    private RecyclerView mapRecyclerView;
    private selector_Fragment selectorFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapRecyclerView = view.findViewById(R.id.mapRecyclerView);
        //setup data
        MapData newMap = MapData.get();
        StructureData newStructureList = StructureData.get();
        //set adapter
        MapAdapter mapAdapter = new MapAdapter(getActivity(), newMap);

        mapRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),MapData.HEIGHT,GridLayoutManager.HORIZONTAL,false));
        mapRecyclerView.setAdapter(mapAdapter);

        return view;
    }
}
