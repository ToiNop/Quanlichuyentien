package com.example.appquanlichitieu.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appquanlichitieu.GiaoDich;
import com.example.appquanlichitieu.GiaoDichAdapter;
import com.example.appquanlichitieu.MyDatabase;
import com.example.appquanlichitieu.R;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {
    ListView ListViewGiaoDich;
    MyDatabase database;

    GiaoDichAdapter giaoDichAdapter;
    List<GiaoDich> giaoDichList;

    public HistoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        ListViewGiaoDich = v.findViewById(R.id.ListViewGiaoDich);
        database = new MyDatabase(getActivity());
        giaoDichList = database.getAllDanhMucGiaoDich(getContext());


        giaoDichAdapter = new GiaoDichAdapter(getContext(), (ArrayList<GiaoDich>) giaoDichList);
        ListViewGiaoDich.setAdapter(giaoDichAdapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Cập nhật lại danh sách giao dịch
        giaoDichList.clear();
        giaoDichList.addAll(database.getAllDanhMucGiaoDich(getContext()));
        giaoDichAdapter.notifyDataSetChanged();
    }
}







