package np.com.xitiz.infostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Info> infoList;
    private RecyclerView recyclerView;
    private InfoAdapter mAdapter;
    private DatabaseHandler databaseHandler;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_tool_bar);
        setSupportActionBar(toolbar);

        infoList = new ArrayList<Info>();
        databaseHandler = new DatabaseHandler(this);
        infoList = databaseHandler.getAllInfo();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        mRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
//        setCustomBackground(R.drawable.warcraft);

        mAdapter = new InfoAdapter(infoList);
//        prepareData();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),3);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

/*    private void prepareData() {
        Info info = new Info(1,"Kshitiz Mandal",
                "12/11/1994",
                "271060/95074",
                "12/11/1994",
                "KTM",
                "NIBL",
                "00505100259149"
        );

//        databaseHandler.addInfo(info);

//        infoList.add(info);
//        infoList.add(info);

        Toast.makeText(this, ""+databaseHandler.getInfoCount(), Toast.LENGTH_SHORT).show();


        infoList = databaseHandler.getAllInfo();
        for (Info info1 : infoList) {
            String log = "Id: " + info1.getId() + " ,Name: " + info1.getName();
            // Writing Contacts to log
            Log.d("Name: ", log);
            Toast.makeText(this,log,Toast.LENGTH_SHORT).show();
        }

        mAdapter.notifyDataSetChanged();

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addInfo:
                Intent intent1 = new Intent(this,AddActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
