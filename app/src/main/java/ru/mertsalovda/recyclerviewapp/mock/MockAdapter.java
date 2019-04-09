package ru.mertsalovda.recyclerviewapp.mock;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mertsalovda.recyclerviewapp.R;

public class MockAdapter extends RecyclerView.Adapter<MockHolder> {

    private final List<Mock> mMockList = new ArrayList<>();

    @NonNull
    @Override
    public MockHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //Получаю LayoutInflater из контекста
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //Получаю элемент View с разметкой li_mock
        View view = inflater.inflate(R.layout.li_mock, parent, false);
        return new MockHolder(view);
    }

    @Override
    public void onBindViewHolder(MockHolder holder, int position) {
        holder.bind(mMockList.get(position));
    }

    @Override
    public int getItemCount() {
        //Количество элементов равно размеру листа
        return mMockList.size();
    }

    public void addData(List<Mock> mocks, boolean refresh){
        //Если false, то данные добавятся, а не обновятсья
        if (refresh) {
            mMockList.clear();
        }
        mMockList.addAll(mocks);
        notifyDataSetChanged();
    }
}
