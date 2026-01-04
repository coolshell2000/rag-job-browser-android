package com.example.ragjobbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JobDetailActivity extends AppCompatActivity {
    private TextView titleTextView, companyTextView, locationTextView, descriptionTextView, salaryTextView, dateTextView;
    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        // 初始化视图
        titleTextView = findViewById(R.id.detailTitleTextView);
        companyTextView = findViewById(R.id.detailCompanyTextView);
        locationTextView = findViewById(R.id.detailLocationTextView);
        descriptionTextView = findViewById(R.id.detailDescriptionTextView);
        salaryTextView = findViewById(R.id.detailSalaryTextView);
        dateTextView = findViewById(R.id.detailDateTextView);
        applyButton = findViewById(R.id.applyJobButton);

        // 从Intent获取工作信息
        Intent intent = getIntent();
        if (intent != null) {
            Job job = (Job) intent.getSerializableExtra("job");
            if (job != null) {
                // 设置工作详情
                titleTextView.setText(job.getTitle());
                companyTextView.setText("公司: " + job.getCompany());
                locationTextView.setText("地点: " + job.getLocation());
                descriptionTextView.setText(job.getDescription());
                salaryTextView.setText(job.getSalary() != null ? job.getSalary() : "薪资: 未提供");
                dateTextView.setText("发布日期: " + job.getPostedDate());

                // 设置申请按钮点击事件
                applyButton.setOnClickListener(v -> {
                    // 打开浏览器申请工作
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(job.getUrl()));
                    startActivity(browserIntent);
                });
            }
        }
    }
}
