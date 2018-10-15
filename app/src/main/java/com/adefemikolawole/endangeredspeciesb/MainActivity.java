package com.adefemikolawole.endangeredspeciesb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {
    final String TAG = MainActivity.class.getSimpleName().toString();
    Integer[] Animals = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla, R.drawable.panda, R.drawable.panther, R.drawable.polar};
    ImageView pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "Application begins here...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        final ImageView pic = findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Selected Species " + (position + 1), Toast.LENGTH_LONG).show();
                pic.setImageResource(Animals[position]);
            }

        });

    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context context) {
            this.context = context; // context is cusomized to hold context resources.

        }

        @Override
        public int getCount() {
            return Animals.length;
        }

        @Override
        public Object getItem(int position) {
            return null;

        }

        @Override
        public long getItemId(int position) {
            return 0;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = findViewById(R.id.imgLarge);

            pic = new ImageView(context); //instance of image view
            pic.setImageResource(Animals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;


        }
    }
}