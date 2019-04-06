package com.rpatil.cybersociety.mobcompqr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;


public class fragmentOperation extends Fragment {

    private static final String TAG = "fragmentOperation";

    private Button Scan;
    private Button Generate;

    public static IntentIntegrator qrScan;

    private OnFragmentInteractionListener mListener;

    public fragmentOperation() {
        // Required empty public constructor
    }

    public static fragmentOperation newInstance() {
        fragmentOperation fragmentOperation = new fragmentOperation();
        Bundle args = new Bundle();
        fragmentOperation.setArguments(args);
        return fragmentOperation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operation, container, false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Scan = view.findViewById(R.id.btn_scan);
        Generate = view.findViewById(R.id.btn_generate);

        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });

        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), fragmentGenerate.class);
                startActivity(i);
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

    }
}
