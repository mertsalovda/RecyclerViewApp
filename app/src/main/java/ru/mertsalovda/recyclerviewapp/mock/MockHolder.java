package ru.mertsalovda.recyclerviewapp.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.mertsalovda.recyclerviewapp.R;

public class MockHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mVolue;


    public MockHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mVolue = itemView.findViewById(R.id.tv_volue);
    }

    public void bind(Mock mock) {
        mName.setText(mock.getmName());
        mVolue.setText(mock.getmValue());

    }
}
