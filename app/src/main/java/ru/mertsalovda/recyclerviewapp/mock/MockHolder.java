package ru.mertsalovda.recyclerviewapp.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.mertsalovda.recyclerviewapp.ContactsAdapter;
import ru.mertsalovda.recyclerviewapp.R;

public class MockHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mVolue;
    private String mId;


    public MockHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mVolue = itemView.findViewById(R.id.tv_volue);
    }

    public void bind(Mock mock) {
        mName.setText(mock.getName());
        mVolue.setText(mock.getValue());
        mId = mock.getValue();
    }

    public void setListener(final ContactsAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mId);
            }
        });
    }
}
