package frmentshector.fragments.com.framents.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import frmentshector.fragments.com.framents.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private EditText etData;
    private Button btnSend;
    private Datalistener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback=(Datalistener) context;
        }catch (Exception e){
            throw  new ClassCastException(context.toString()+" error DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        etData=(EditText)view.findViewById(R.id.etData);
        btnSend=(Button) view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(etData.getText().toString());
            }
        });
        return view;
    }

    private void sendText(String text){
        callback.sendData(text);
    }

    public interface Datalistener{
        void sendData(String text);
    }
}
