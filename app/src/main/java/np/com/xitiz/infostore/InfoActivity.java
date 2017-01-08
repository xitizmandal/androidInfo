package np.com.xitiz.infostore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by xitiz on 12/17/16.
 */
public class InfoActivity extends AppCompatActivity{
    public static final String EXTRA_PARAM_ID = "id";
    public static final String EXTRA_PARAM_PERSON_NAME = "personName";
    public static final String EXTRA_PARAM_DOB = "dateOfBirth";
    public static final String EXTRA_PARAM_CITIZENSHIP_NUMBER = "citizenShipNumber";
    public static final String EXTRA_PARAM_CITIZENSHIP_ISSUE_DATE = "issueDate";
    public static final String EXTRA_PARAM_CITIZENSHIP_ISSUE_PLACE = "issuePlace";
    public static final String EXTRA_PARAM_BANK_NAME = "bankName";
    public static final String EXTRA_PARAM_ACC_NUMBER = "accNumber";
    public static final String EXTRA_PARAM_FATHER_NAME = "fatherName";
    public static final String EXTRA_PARAM_GRAND_FATHER_NAME = "grandFatherName";
    public static final String EXTRA_PARAM_DP_ID = "dpID";
    public static final String EXTRA_PARAM_CLIENT_ID = "clientID";
    public static final String EXTRA_PARAM_PERMANENT_ADDRESS = "permanentAddress";
    public static final String EXTRA_PARAM_CURRENT_ADDRESS = "currentAddress";
    public static final String EXTRA_PARAM_ONLINE_PASSWORD =  "onlinePassword";

    private Intent intent;
    private TextView mPersonNameTV;
    private TextView mDOBTV;
    private TextView mCitizenNoTV;
    private TextView mCitizenIssueDateTV;
    private TextView mCitizenIssuePlaceTV;
    private TextView mBankNameTV;
    private TextView mAccNumberTV;
    private TextView mFatherNameTV;
    private TextView mGrandFatherTV;
    private TextView mDpIDTV;
    private TextView mClientID;
    private TextView mPermanentAdd;
    private TextView mCurrentAdd;
    private TextView mOnlinePWD;
    private ImageButton mDeleteButton;
    private ImageButton mBackButton;
    private FloatingActionButton mEditFAB;


    private DatabaseHandler mDatabaseHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info_test);

        initialize();

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(InfoActivity.this, "" + intent.getExtras().getInt(EXTRA_PARAM_ID), Toast.LENGTH_SHORT).show();
//                mDatabaseHandler.deleteInfo(intent.getExtras().getInt(EXTRA_PARAM_ID));
                dialogPrompt();
            }
        });

        mEditFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(InfoActivity.this,EditActivity.class);
                intent1.putExtra(EXTRA_PARAM_ID,intent.getExtras().getInt(EXTRA_PARAM_ID));
                startActivity(intent1);
            }
        });
    }

    void initialize(){
        intent = this.getIntent();
        mPersonNameTV = (TextView) findViewById(R.id.personNameTV);
        mDOBTV = (TextView) findViewById(R.id.dOBTV);
        mCitizenNoTV = (TextView) findViewById(R.id.citizenNoTV);
        mCitizenIssueDateTV = (TextView) findViewById(R.id.citizenIssueDateTV);
        mCitizenIssuePlaceTV = (TextView) findViewById(R.id.citizenIssuePlaceTV);
        mBankNameTV = (TextView) findViewById(R.id.bankNameTV);
        mAccNumberTV = (TextView) findViewById(R.id.accNumberTV);
        mFatherNameTV = (TextView) findViewById(R.id.fatherNameTV);
        mGrandFatherTV = (TextView) findViewById(R.id.grandFatherTV);
        mDpIDTV = (TextView) findViewById(R.id.dpIDTV);
        mClientID = (TextView) findViewById(R.id.clientIDTV);
        mPermanentAdd = (TextView) findViewById(R.id.permanentAddTV);
        mCurrentAdd = (TextView) findViewById(R.id.currentAddTV);
        mOnlinePWD = (TextView) findViewById(R.id.onlinePWDTV);
        mEditFAB = (FloatingActionButton) findViewById(R.id.editFAB);

        mDeleteButton = (ImageButton) findViewById(R.id.deleteIB);
        mBackButton = (ImageButton) findViewById(R.id.backArrow);

        mDatabaseHandler = new DatabaseHandler(this);

        Info info = mDatabaseHandler.getSingleInfo(intent.getExtras().getInt(EXTRA_PARAM_ID));

        mPersonNameTV.setText(info.getName());
        mDOBTV.setText(info.getDateOfBirth());
        mCitizenNoTV.setText(info.getCitizenShipNumber());
        mCitizenIssueDateTV.setText(info.getCitizenShipIssueDate());
        mCitizenIssuePlaceTV.setText(info.getCitizenShipIssuePlace());
        mBankNameTV.setText(info.getBankName());
        mAccNumberTV.setText(info.getAccNumber());
        mFatherNameTV.setText(info.getFatherName());
        mGrandFatherTV.setText(info.getGrandFatherName());
        mDpIDTV.setText(info.getDpID());
        mClientID.setText(info.getClientID());
        mPermanentAdd.setText(info.getPermanentAdd());
        mCurrentAdd.setText(info.getCurrentAdd());
        mOnlinePWD.setText(info.getOnlinePWD());

/*        mPersonNameTV.setText(intent.getExtras().getString(EXTRA_PARAM_PERSON_NAME));
        mDOBTV.setText(intent.getExtras().getString(EXTRA_PARAM_DOB));
        mCitizenNoTV.setText(intent.getExtras().getString(EXTRA_PARAM_CITIZENSHIP_NUMBER));
        mCitizenIssueDateTV.setText(intent.getExtras().getString(EXTRA_PARAM_CITIZENSHIP_ISSUE_DATE));
        mCitizenIssuePlaceTV.setText(intent.getExtras().getString(EXTRA_PARAM_CITIZENSHIP_ISSUE_PLACE));
        mBankNameTV.setText(intent.getExtras().getString(EXTRA_PARAM_BANK_NAME));
        mAccNumberTV.setText(intent.getExtras().getString(EXTRA_PARAM_ACC_NUMBER));
        mFatherNameTV.setText(intent.getExtras().getString(EXTRA_PARAM_FATHER_NAME));
        mGrandFatherTV.setText(intent.getExtras().getString(EXTRA_PARAM_GRAND_FATHER_NAME));
        mDpIDTV.setText(intent.getExtras().getString(EXTRA_PARAM_DP_ID));
        mClientID.setText(intent.getExtras().getString(EXTRA_PARAM_CLIENT_ID));
        mPermanentAdd.setText(intent.getExtras().getString(EXTRA_PARAM_PERMANENT_ADDRESS));
        mCurrentAdd.setText(intent.getExtras().getString(EXTRA_PARAM_CURRENT_ADDRESS));
        mOnlinePWD.setText(intent.getExtras().getString(EXTRA_PARAM_ONLINE_PASSWORD));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.deleteInfo:
                dialogPrompt();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void dialogPrompt(){
        new AlertDialog.Builder(this)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mDatabaseHandler.deleteInfo(intent.getExtras().getInt(EXTRA_PARAM_ID));
                        // continue with delete
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
