package com.example.viewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewapp.R;

import java.util.List;

public class Data {
    public static String[] titleList = {"Web Design", "Mobile Development", "Game Development", "Data Science", "Info Graphic"};
    public static String[] subList = {"What is Web Design?", "Mobile Dev Career Paths", "Become a Game Developer", "How to Learn Data Science", "What is Info Graphic?"};
    public static int[] imageList = {R.drawable.web, R.drawable.mobile, R.drawable.game, R.drawable.data, R.drawable.info};

    public static class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        List<String> menu;
        List<Integer> image;
        LayoutInflater inflater;

        public Adapter(Context ctx, List<String> menu, List<Integer> image) {
            this.menu = menu;
            this.image = image;
            this.inflater = LayoutInflater.from(ctx);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView menuTitle;
            private ImageView image;

            public ViewHolder(View itemView) {
                super(itemView);
                menuTitle = itemView.findViewById(R.id.title);
                image = itemView.findViewById(R.id.image);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_menu, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.menuTitle.setText(menu.get(position));
            holder.image.setImageResource(image.get(position));
        }

        @Override
        public int getItemCount() {
            return menu.size();
        }
    }
}
