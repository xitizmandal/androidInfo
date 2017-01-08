package np.com.xitiz.infostore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static np.com.xitiz.infostore.InfoActivity.EXTRA_PARAM_ID;

/**
 * Created by xitiz on 1/2/17.
 */

public class EditActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Intent intent;
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
    private Button mUpdateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        toolbar = (Toolbar) findViewById(R.id.app_tool_bar);
        setSupportActionBar(toolbar);

        initialize();

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AddActivity.this, "Adding info", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(EditActivity.this)
                        .setTitle("Update entry")
                        .setMessage("Are you sure you want to update this entry?")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                updateInfos();
                                // continue with delete
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_menu_edit)
                        .show();
//               update();
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

        mUpdateButton = (Button) findViewById(R.id.updateButton);

        databaseHandler = new DatabaseHandler(this);
        intent = this.getIntent();

        Info info = databaseHandler.getSingleInfo(intent.getExtras().getInt(EXTRA_PARAM_ID));
//        Toast.makeText(this, "XXX" + info.getName(), Toast.LENGTH_SHORT).show();

        mNameET.setText(info.getName());
        mDOBET.setText(info.getDateOfBirth());
        mCitizenNoET.setText(info.getCitizenShipNumber());
                mCitizenDateET.setText(info.getCitizenShipIssueDate());
                mCitizenIssueET.setText(info.getCitizenShipIssuePlace());
                mBankNameET.setText(info.getBankName());
                mAccNumberET.setText(info.getAccNumber());
                mFatherNameET.setText(info.getFatherName());
                mGrandFatherET.setText(info.getGrandFatherName());
                mDpIDET.setText(info.getDpID());
                mClientIDET.setText(info.getClientID());
                mPermanentAdd.setText(info.getPermanentAdd());
                mCurrentAdd.setText(info.getCurrentAdd());
                mOnlinePWD.setText(info.getOnlinePWD());

    }

    void updateInfos(){
        Info info = new Info(
                intent.getExtras().getInt(EXTRA_PARAM_ID),
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
        );

        databaseHandler.updateInfo(info);
    }
}
