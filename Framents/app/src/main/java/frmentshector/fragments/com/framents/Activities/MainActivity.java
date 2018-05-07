package frmentshector.fragments.com.framents.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import frmentshector.fragments.com.framents.Fragments.DataFragment;
import frmentshector.fragments.com.framents.Fragments.DetailsFragment;
import frmentshector.fragments.com.framents.R;

public class MainActivity extends FragmentActivity implements DataFragment.Datalistener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public  void sendData(String text){
        DetailsFragment detailsFragment= (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}
