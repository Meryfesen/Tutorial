package au.edu.unsw.infs3634.week4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;

    private ClickListener mListener;

    public CountryAdapter(Context ct, String s1[], String s2[], String s3[], int img[], ClickListener listener){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
        mListener = listener;


    }

    //Allows click events to be caught
    public interface ClickListener{
        void onCountryClick(View view, int CountryID);
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.country_row, parent , false);

        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int countryID = position;
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myImages.setImageResource(images[position]);
        holder.itemView.setTag(countryID);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("myImages", images[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myText1, myText2, myText3;
        ImageView myImages;
        ConstraintLayout mainLayout;
        private ClickListener listener;

        public MyViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(MyViewHolder.this);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myText3 = itemView.findViewById(R.id.myText3);
            myImages = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

        @Override
        public void onClick(View v) {
            listener.onCountryClick(v, (Integer) v.getTag());
        }
    }
}
