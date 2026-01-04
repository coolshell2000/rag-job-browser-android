package com.example.ragjobbrowser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private List<Job> jobList;
    private Context context;

    public JobAdapter(List<Job> jobList, Context context) {
        this.jobList = jobList;
        this.context = context;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);
        
        holder.titleTextView.setText(job.getTitle());
        holder.companyTextView.setText(job.getCompany());
        holder.locationTextView.setText(job.getLocation());
        holder.descriptionTextView.setText(job.getDescription());
        
        // 设置整个项目点击事件以查看详情
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, JobDetailActivity.class);
            intent.putExtra("job", job);
            context.startActivity(intent);
        });
        
        holder.viewJobButton.setOnClickListener(v -> {
            // 打开浏览器查看工作详情
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(job.getUrl()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, companyTextView, locationTextView, descriptionTextView;
        Button viewJobButton;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            
            titleTextView = itemView.findViewById(R.id.titleTextView);
            companyTextView = itemView.findViewById(R.id.companyTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            viewJobButton = itemView.findViewById(R.id.viewJobButton);
        }
    }
}
