package com.example.cjcucsie.new_list;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
//        import android.view.LayoutInflater;
 //       import android.view.View;
  //      import android.view.ViewGroup;
   //     import android.widget.EditText;
    //    import android.widget.TextView;
        //    import android.widget.Toast;

        import java.util.ArrayList;
  //      import java.util.Date;
  //      import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText edit;
    Button txtButton;

//    @Override
//    public <T extends View> T findViewById(int id) {
//        return super.findViewById(R.id.button);
//    }

            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> myDataset = new ArrayList<>();

        mAdapter = new MyAdapter(myDataset);


//        myDataset.add("");
//        mAdapter.notifyDataSetChanged();

        txtButton = findViewById(R.id.button);
        txtButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(!edit.getText().toString().equals("")) {
                    myDataset.add(edit.getText().toString());
                    mAdapter.notifyDataSetChanged();
                    edit.setText("");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Enter item", Toast.LENGTH_SHORT).show();
                    
                }
            }

//            @Override
//            public void onClick(View view) {
//
//                myDataset.remove();
//                mAdapter.notifyDataSetChanged();
//            }
        });
        edit = findViewById(R.id.edit1);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
//        @Override
//        public void onClick (View) {
//                myDataset.add(Integer.toString(i));
//        mAdapter.notifyDataSetChanged();
//        }
    }
}

