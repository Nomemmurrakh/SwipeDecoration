package com.nomemmurrakh.swipeviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;

import com.nomemmurrakh.swipedecor.SwipeDecoration;
import com.nomemmurrakh.swipeviewexample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private SwipeDecoration decoration;
    private ArrayList<com.nomemmurrakh.swipeviewexample.Color> colors;
    private ColorAdapter adapter;
    private ActivityMainBinding mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainActivity.getRoot());

        decoration = new SwipeDecoration.Builder(MainActivity.this)
                .setIconLeftAnimDrawable(R.drawable.animated_vector_update)
                .setIconRightResource(R.drawable.ic_send_black_24dp)
                .setBackgroundLeftColor(Color.CYAN)
                .setBackgroundRightColor(Color.GRAY)
                .setIconRightAnimation(SwipeDecoration.ANIMATION_FADE)
                .build();

        colors = new ArrayList<>();
        setColors();
        setColorList();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                decoration.applyDecoration(c, viewHolder, dX);

            }
        }).attachToRecyclerView(mainActivity.listColors);

    }

    private void setColors(){
        colors.add(new com.nomemmurrakh.swipeviewexample.Color(
                1,
                "CYAN",
                Color.CYAN
        ));

        colors.add(new com.nomemmurrakh.swipeviewexample.Color(
                2,
                "DKGRAY",
                Color.DKGRAY
        ));

        colors.add(new com.nomemmurrakh.swipeviewexample.Color(
                3,
                "GRAY",
                Color.GRAY
        ));

        colors.add(new com.nomemmurrakh.swipeviewexample.Color(
                4,
                "MAGENTA",
                Color.MAGENTA
        ));
    }

    private void setColorList(){

        adapter = new ColorAdapter(MainActivity.this, colors);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mainActivity.listColors.setLayoutManager(layoutManager);
        mainActivity.listColors.setAdapter(adapter);
    }
}
