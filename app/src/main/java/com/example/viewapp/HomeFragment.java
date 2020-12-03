package com.example.viewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private TextView textTitle;
    private TextView subTitle;
    private ImageView image;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        textTitle = (TextView) view.findViewById(R.id.title);
        subTitle = (TextView) view.findViewById(R.id.sub_title);
        image = (ImageView) view.findViewById(R.id.image);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<DataNote>();
        for (int i = 0; i < Data.titleList.length; i++) {
            data.add(new DataNote(Data.titleList[i],
                    Data.subList[i],
                    Data.imageList[i]));
        }
        listAdapter = new ListAdapter(data);
        recyclerView.setAdapter(listAdapter);

        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private ArrayList<DataNote> dataList;

        public ListAdapter(ArrayList<DataNote> data) {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textTitle;
            private TextView subTitle;
            private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.title);
            subTitle = (TextView) itemView.findViewById(R.id.sub_title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home, parent, false);

        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
        TextView title = (TextView) holder.itemView.findViewById(R.id.title);
        TextView sub = (TextView) holder.itemView.findViewById(R.id.sub_title);
        ImageView image = (ImageView) holder.itemView.findViewById(R.id.image);

        title.setText(dataList.get(position).getTitle());
        sub.setText(dataList.get(position).getSub());
        image.setImageResource(dataList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Card " + position + " is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }
}