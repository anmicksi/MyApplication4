package com.example.myapplication4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.util.Log;
import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{
    private final static String TAG = "NewTag123";
    private final LayoutInflater inflater;
    private final ArrayList<String> items;
    MyRecyclerAdapter(Context context, ArrayList<String> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items.get(position);
        holder.text.setText(item);
        holder.image.setImageDrawable(inflater.getContext().getDrawable(R.drawable.question_box));
        holder.layout.setOnClickListener(view -> {
            Toast.makeText(inflater.getContext(), item, Toast.LENGTH_LONG).show();
            Log.d(TAG, item);
        });
    }

    @Override
    public int getItemCount(){
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;
        public ViewGroup layout;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_list_text_view);
            image = itemView.findViewById(R.id.item_list_image_view);
            layout = itemView.findViewById(R.id.item_root_container);
        }
    }
}
