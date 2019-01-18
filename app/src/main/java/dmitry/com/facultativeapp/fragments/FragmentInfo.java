package dmitry.com.facultativeapp.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import dmitry.com.facultativeapp.R;
import dmitry.com.facultativeapp.helpers.Instruments;


public class FragmentInfo extends Fragment {

    private TextView tvIp;
    private TextView tvModel;
    private TextView tvDevice;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_info, container, false);
        tvIp = v.findViewById(R.id.tvIp);
        tvModel = v.findViewById(R.id.tvModel);
        tvDevice = v.findViewById(R.id.tvDevice);

        Objects.requireNonNull(getActivity()).setTitle("Information");

        return  v;
    }

    @Override
    public void onStart() {
        super.onStart();

        String wifiIP = Instruments.getWifiIPAddress(getContext());
        String modelValue = Build.MODEL;
        String version = Build.DEVICE;

        tvIp.setText("IP: " + wifiIP);
        tvModel.setText("Model: " + modelValue);
        tvDevice.setText("Version: " + version);
    }
}
