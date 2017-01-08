package np.com.xitiz.infostore;

/**
 * Created by xitiz on 12/16/16.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder>{

    private List<Info> infoList;
    public MyClicks mClicks;
    private Context context;

    public InfoAdapter(List<Info> infoList) {
        this.infoList = infoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_child, parent, false);
        InfoAdapter.MyViewHolder myViewHolder = new MyViewHolder(itemView, new InfoAdapter.MyClicks() {
            @Override
            public void clickOnRow(View view, int pos) {
                Info info = infoList.get(pos);
//                Toast.makeText(context, "Row clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,InfoActivity.class);
                intent.putExtra(InfoActivity.EXTRA_PARAM_ID, info.getId())
                        /*.putExtra(InfoActivity.EXTRA_PARAM_PERSON_NAME,info.getName())
                        .putExtra(InfoActivity.EXTRA_PARAM_DOB, info.getDateOfBirth())
                        .putExtra(InfoActivity.EXTRA_PARAM_CITIZENSHIP_NUMBER,info.getCitizenShipNumber())
                        .putExtra(InfoActivity.EXTRA_PARAM_CITIZENSHIP_ISSUE_DATE,info.getCitizenShipIssueDate())
                        .putExtra(InfoActivity.EXTRA_PARAM_CITIZENSHIP_ISSUE_PLACE,info.getCitizenShipIssuePlace())
                        .putExtra(InfoActivity.EXTRA_PARAM_BANK_NAME,info.getBankName())
                        .putExtra(InfoActivity.EXTRA_PARAM_ACC_NUMBER,info.getAccNumber())
                        .putExtra(InfoActivity.EXTRA_PARAM_FATHER_NAME,info.getFatherName())
                        .putExtra(InfoActivity.EXTRA_PARAM_GRAND_FATHER_NAME,info.getGrandFatherName())
                        .putExtra(InfoActivity.EXTRA_PARAM_DP_ID,info.getDpID())
                        .putExtra(InfoActivity.EXTRA_PARAM_CLIENT_ID,info.getClientID())
                        .putExtra(InfoActivity.EXTRA_PARAM_PERMANENT_ADDRESS,info.getPermanentAdd())
                        .putExtra(InfoActivity.EXTRA_PARAM_CURRENT_ADDRESS,info.getCurrentAdd())
                        .putExtra(InfoActivity.EXTRA_PARAM_ONLINE_PASSWORD,info.getOnlinePWD())*/
                ;


                context.startActivity(intent);
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Info info = infoList.get(position);
        holder.name.setText(info.getName());

    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;

        public MyViewHolder(View view, MyClicks listener) {
            super(view);
            mClicks = listener;
            context = view.getContext();
            name = (TextView) view.findViewById(R.id.name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mClicks.clickOnRow(v, getLayoutPosition());
        }

    }

    public static interface MyClicks{
        public void clickOnRow(View info, int pos);
    }
}

