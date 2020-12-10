package com.amod.room_database_project.adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amod.room_database_project.R;
import com.amod.room_database_project.activities.SecondActivity;
import com.amod.room_database_project.constants.Constants;
import com.amod.room_database_project.database.AppDatabase;
import com.amod.room_database_project.model.Person;

import java.util.List;

public class Adaptor_Data extends RecyclerView.Adapter<Adaptor_Data.MyViewHolder> {
    private Context context;
    private List<Person> mPersonList;

    public Adaptor_Data(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor_Data.MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(mPersonList.get(i).getName());
        myViewHolder.email.setText(mPersonList.get(i).getEmail());
        myViewHolder.number.setText(mPersonList.get(i).getNumber());
        myViewHolder.pincode.setText(mPersonList.get(i).getPincode());
        myViewHolder.city.setText(mPersonList.get(i).getCity());
    }

    @Override
    public int getItemCount() {
        if (mPersonList == null) {
            return 0;
        }
        return mPersonList.size();

    }

    public void setTasks(List<Person> personList) {
        mPersonList = personList;
        notifyDataSetChanged();
    }

    public List<Person> getTasks() {

        return mPersonList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, pincode, number, city;
        ImageView editImage;
        AppDatabase mDb;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            mDb = AppDatabase.getInstance(context);
            name = itemView.findViewById(R.id.person_name);
            email = itemView.findViewById(R.id.person_email);
            pincode = itemView.findViewById(R.id.person_pincode);
            number = itemView.findViewById(R.id.person_number);
            city = itemView.findViewById(R.id.person_city);
            editImage = itemView.findViewById(R.id.edit_Image);
            editImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int elementId = mPersonList.get(getAdapterPosition()).getId();
                    Intent i = new Intent(context, SecondActivity.class);
                    i.putExtra(Constants.Person_Id, elementId);
                    context.startActivity(i);
                }
            });
        }
    }
}
