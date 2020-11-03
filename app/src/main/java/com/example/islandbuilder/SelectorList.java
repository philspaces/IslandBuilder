package com.example.islandbuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class SelectorList extends RecyclerView.Adapter<SelectorList.SelectorVHolder> {

    private static Structure selectedItem = null;
    private List<Structure> mData = new ArrayList<>();
    private Context mContext;

    public SelectorList(Context inContext,List<Structure> inData) {
        this.mData = inData;
        mContext = inContext;
    }

    @NonNull
    @Override
    public SelectorVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_selection, parent, false);
        SelectorVHolder holder = new SelectorVHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectorVHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SelectorVHolder extends RecyclerView.ViewHolder{
        //reference field
        private ImageView selectorImage;
        private TextView selectorText;
        public SelectorVHolder(View itemView) {
            super(itemView);
            selectorImage = itemView.findViewById(R.id.selectorImage);
            selectorText = itemView.findViewById(R.id.selectorText);

        }
        public void bind(final Structure structure ){
            selectorText.setText(structure.getLabel());
            selectorImage.setImageResource(structure.getDrawableId());
            selectorImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedItem = structure;
                    Toast.makeText(mContext, "Selected " + structure.getLabel(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public static Structure getSelectedItem() {
        return selectedItem;
    }
}
