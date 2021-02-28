package jc.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import cdflynn.android.library.turn.TurnLayoutManager;

public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
    private ListAdapter ListAdapter;
    private ArrayList<ListModel> ListModels;
    TurnLayoutManager layoutManager;


    private int[] images = {R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test
            , R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test
            , R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test, R.drawable.shape_test};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv30);
        ListModels = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ListModel listModel = new ListModel();
            listModel.setImage(images[i]);
            ListModels.add(listModel);
        }

        ListAdapter = new ListAdapter(ListModels);

        final int radius = (int) getResources().getDimension(R.dimen.a);
        final int peek = (int) getResources().getDimension(R.dimen.a);
        layoutManager = new TurnLayoutManager(this,
                TurnLayoutManager.Gravity.END,
                TurnLayoutManager.Orientation.HORIZONTAL,
                radius,
                peek,
                 false);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(ListAdapter);





    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    class ListModel {
         private int image;

        public ListModel() {
        }

        public ListModel(  int image) {

            this.image = image;
        }



        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

        private ArrayList<ListModel> modelArrayList;

        public ListAdapter(ArrayList<ListModel> modelArrayList) {
            this.modelArrayList = modelArrayList;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
             private ImageView mImage;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                mImage = itemView.findViewById(R.id.cart_image);
            }
        }

        @NonNull
        @Override
        public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
            ListModel listModel = modelArrayList.get(position);

            holder.mImage.setImageResource(listModel.getImage());


        }
        @Override
        public int getItemCount() {
            return modelArrayList.size();
        }

    }
}

