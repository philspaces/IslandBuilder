package com.example.islandbuilder;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapVHolder> {
    private static final String TAG = "MapAdapter";
    private MapData mapData;
    private Context mContext;

    public MapAdapter(Context mContext, MapData mapData) {
        this.mapData = mapData;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public MapVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(mContext);

        MapVHolder holder = new MapVHolder(li,parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MapVHolder holder, int position) {
        final int row = position % MapData.HEIGHT;
        final int col = position / MapData.HEIGHT;
        MapElement element = mapData.get(row,col);
        holder.bind(element);

        Log.d(TAG, "onBindViewHolder: set up map");
    }

    //stuck here
    @Override
    public int getItemCount() {
        return MapData.HEIGHT * MapData.WIDTH;
    }

    public class MapVHolder extends RecyclerView.ViewHolder {

        private ImageView firstView;
        private ImageView secondView;
        private ImageView thirdView;
        private ImageView forthView;
        private ImageView fifthView;

        public MapVHolder(LayoutInflater li,@NonNull ViewGroup parent) {
            super(li.inflate(R.layout.grid_cell,parent,false));
            int size = parent.getMeasuredHeight() / mapData.HEIGHT + 1;
            ViewGroup.LayoutParams lp = itemView.getLayoutParams();
            lp.width = size;
            lp.height = size;
            firstView = itemView.findViewById(R.id.firstView);
            secondView = itemView.findViewById(R.id.secondView);
            thirdView = itemView.findViewById(R.id.thirdView);
            forthView = itemView.findViewById(R.id.forthView);
            fifthView = itemView.findViewById(R.id.fifthView);

        }

        public void bind(final MapElement data){
            firstView.setImageResource(data.getNorthWest());
            secondView.setImageResource(data.getNorthEast());
            thirdView.setImageResource(data.getSouthWest());
            forthView.setImageResource(data.getSouthEast());
            fifthView.setImageResource(0); //refresh


            //set fifth View if data is drawable
            fifthView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(data.isBuildable()){
                        Structure selectedItem = SelectorList.getSelectedItem();
                        if(selectedItem != null){
                            fifthView.setImageResource(selectedItem.getDrawableId());
                            notifyItemChanged(getAdapterPosition()); // ???????????????????????????????????????????????????????????
                            Toast.makeText(mContext, "Placed: "+ selectedItem.getLabel() , Toast.LENGTH_SHORT).show();
                        }
                        else
                        Toast.makeText(mContext, "Structure hasn't selected: "+selectedItem+"", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(mContext, "Not Safe To Live", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
