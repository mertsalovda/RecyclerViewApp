package ru.mertsalovda.recyclerviewapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mertsalovda.recyclerviewapp.mock.Mock;
import ru.mertsalovda.recyclerviewapp.mock.MockAdapter;
import ru.mertsalovda.recyclerviewapp.mock.MockGenerator;

public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private final MockAdapter mockAdapter = new MockAdapter();

    public static RecyclerFragment newInstance() {

        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mockAdapter);
        mockAdapter.addData(MockGenerator.generate(20));
    }
}
