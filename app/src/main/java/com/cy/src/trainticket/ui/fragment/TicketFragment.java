package com.cy.src.trainticket.ui.fragment;


import android.app.Activity;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cy.src.entity.TicketModel;
import com.cy.src.trainticket.R;
import com.cy.src.trainticket.base.RecyclerViewAdapter;
import com.cy.src.trainticket.data.api.ApiExecutor;
import com.cy.src.trainticket.data.info.Station;
import com.cy.src.trainticket.databinding.ItemTicketBinding;
import com.cy.src.trainticket.ui.activity.SelectStationActivity;
import com.google.gson.Gson;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author CY
 * @since 2016/9/27
 * email tmxdyf@163.com
 */
public class TicketFragment extends Fragment {


    private RecyclerView mRecyclerView;

    private TicketAdapter mAdapter;

    private Subscription mSubscription;

    public TicketFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new TicketAdapter();
        query("SZQ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (mSubscription != null && mSubscription.isUnsubscribed()) {
                mSubscription.unsubscribe();
            }
            mAdapter.clear();
            Station station = data.getParcelableExtra("data");
            query(station.getValue());
        }
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(mAdapter);
        view.findViewById(R.id.btn_start_station).setOnClickListener(v -> {
            startActivityForResult(new Intent(getActivity(), SelectStationActivity.class), 1);
        });
    }

    private void query(String startStation) {
        if (getView() != null) {
            getView().findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }
        mSubscription = new ApiExecutor().queryNextTicket("2016-09-30", getActivity(), startStation).subscribe(new Subscriber<TicketModel>() {

            @Override
            public void onNext(TicketModel ticketModels) {
                mAdapter.add(ticketModels);
            }

            @Override
            public void onCompleted() {
                Log.e("ApiTest", "query ticket completed");
                new AlertDialog.Builder(getActivity()).setMessage("查询完成").create().show();
                if (getView() != null) {
                    getView().findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

        });
    }


    public static class TicketAdapter extends RecyclerViewAdapter<TicketModel> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemTicketBinding binding = ItemTicketBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new Holder(binding);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            Holder h = (Holder) holder;
            h.setData(position, getItem(position));
        }


        public static class Holder extends RecyclerView.ViewHolder {
            private ItemTicketBinding mBinding;

            public Holder(ItemTicketBinding binding) {
                super(binding.getRoot());
                mBinding = binding;
            }

            public void setData(int position, TicketModel model) {
                mBinding.setTicket(model);
            }

            @BindingAdapter("setJson")
            public static void setJson(TextView textView, TicketModel model) {

                textView.setText(new Gson().toJson(model));
            }
        }
    }
}
