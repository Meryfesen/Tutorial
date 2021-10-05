package au.edu.unsw.infs3634.week4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Country> mCountry = new ArrayList<>();
    RecyclerView recyclerView;

    String s1[], s2[], s3[];
    CountryAdapter.ClickListener listener;
    int images[] = {R.drawable.ic_launcher_round, R.drawable.ic_launcher_round,
            R.drawable.ic_launcher_round, R.drawable.ic_launcher_round, R.drawable.ic_launcher_round,
            R.drawable.ic_launcher_round, R.drawable.ic_launcher_round, R.drawable.ic_launcher_round,
            R.drawable.ic_launcher_round};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);


        s1 = getResources().getStringArray(R.array.countries_names);
        s2 = getResources().getStringArray(R.array.total_case);
        s3 = getResources().getStringArray(R.array.new_case);

        CountryAdapter myAdapter = new CountryAdapter(this, s1, s2, s3, images, listener);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CountryAdapter.ClickListener listener = new CountryAdapter.ClickListener() {
            @Override
            public void onCountryClick(View view, int CountryID) {
                final Country country = mCountry.get(CountryID);
                Toast.makeText(getApplicationContext(), country.getCountry(), Toast.LENGTH_SHORT);
            }


        };
    }
}