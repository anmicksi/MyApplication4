package com.example.myapplication4;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstScreen extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_screen, container, false);
        Button toSecondScreen = view.findViewById(R.id.to_second_screen);
        Button toThirdScreen = view.findViewById(R.id.to_third_screen);
        toSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).replace(R.id.fragment_container_view,
                                new SecondScreen()).addToBackStack(null).commit();
            }
        });
        toThirdScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).replace(R.id.fragment_container_view,
                                new ThirdScreen()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
