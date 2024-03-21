package com.example.myapplication4;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdScreen extends Fragment {

    public static ArrayList<String> Items() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("different item #" + (i + 1));
        }
        return list;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_screen, container, false);
        RecyclerView itemsList = view.findViewById(R.id.recycler_view);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getContext(), Items());
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);
        return view;
    }

}
