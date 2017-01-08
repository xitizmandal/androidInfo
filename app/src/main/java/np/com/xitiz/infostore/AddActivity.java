package np.com.xitiz.infostore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xitiz on 12/28/16.
 */

public class AddActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private EditText mNameET;
    private EditText mDOBET;
    private EditText mCitizenNoET;
    private EditText mCitizenDateET;
    private EditText mCitizenIssueET;
    private EditText mBankNameET;
    private EditText mAccNumberET;
    private EditText mFatherNameET;
    private EditText mGrandFatherET;
    private EditText mDpIDET;
    private EditText mClientIDET;
    private EditText mPermanentAdd;
    private EditText mCurrentAdd;
    private EditText mOnlinePWD;
    private DatabaseHandler databaseHandler;
    private Button mAddButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_layout);
        toolbar = (Toolbar) findViewById(R.id.app_tool_bar);
        setSupportActionBar(toolbar);

        initialize();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AddActivity.this, "Adding info", Toast.LENGTH_SHORT).show();
                databaseHandler.addInfo(new Info(
                                mNameET.getText().toString(),
                                mDOBET.getText().toString(),
                                mCitizenNoET.getText().toString(),
                                mCitizenDateET.getText().toString(),
                                mCitizenIssueET.getText().toString(),
                                mBankNameET.getText().toString(),
                                mAccNumberET.getText().toString(),
                                mFatherNameET.getText().toString(),
                                mGrandFatherET.getText().toString(),
                                mDpIDET.getText().toString(),
                                mClientIDET.getText().toString(),
                                mPermanentAdd.getText().toString(),
                                mCurrentAdd.getText().toString(),
                                mOnlinePWD.getText().toString()
                        )
                );
                Toast.makeText(AddActivity.this, "Adding info: " + mNameET.getText().toString(), Toast.LENGTH_SHORT)
                        .show();
                Intent intent =  new Intent(getApplicationContext(), InfoActivity.class);
//                intent.putExtra()
            }
        });


    }

    public void initialize() {
        mNameET = (EditText) findViewById(R.id.nameET);
        mDOBET = (EditText) findViewById(R.id.dOBET);
        mCitizenNoET = (EditText) findViewById(R.id.citizenNoET);
        mCitizenDateET = (EditText) findViewById(R.id.citizenDateET);
        mCitizenIssueET = (EditText) findViewById(R.id.citizenIssueET);
        mBankNameET = (EditText) findViewById(R.id.bankNameET);
        mAccNumberET = (EditText) findViewById(R.id.accNumberET);
        mFatherNameET = (EditText) findViewById(R.id.fatherNameET);
        mGrandFatherET = (EditText) findViewById(R.id.grandFatherET);
        mDpIDET = (EditText) findViewById(R.id.dpIDET);
        mClientIDET = (EditText) findViewById(R.id.clientIDET);
        mPermanentAdd = (EditText) findViewById(R.id.permanentAddET);
        mCurrentAdd = (EditText) findViewById(R.id.currentAddET);
        mOnlinePWD = (EditText) findViewById(R.id.onlinePWDET);

        mAddButton = (Button) findViewById(R.id.addButton);

        databaseHandler = new DatabaseHandler(this);
    }
}
