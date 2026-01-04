package com.example.ragjobbrowser;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;
    private List<Job> jobList;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化视图
        recyclerView = findViewById(R.id.recyclerView);
        SearchView searchView = findViewById(R.id.searchView);

        // 初始化工作列表
        jobList = new ArrayList<>();
        jobAdapter = new JobAdapter(jobList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(jobAdapter);

        // 初始化API服务
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/") // 使用Android模拟器的localhost
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        // 加载所有工作
        loadAllJobs();

        // 设置搜索功能
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchJobs(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 2) {
                    searchJobs(newText);
                } else if (newText.isEmpty()) {
                    loadAllJobs();
                }
                return true;
            }
        });
    }

    private void loadAllJobs() {
        Call<List<Job>> call = apiService.getAllJobs();
        call.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    jobList.clear();
                    jobList.addAll(response.body());
                    jobAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                // 处理错误
            }
        });
    }

    private void searchJobs(String query) {
        Call<List<Job>> call = apiService.searchJobs(query);
        call.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    jobList.clear();
                    jobList.addAll(response.body());
                    jobAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                // 处理错误
            }
        });
    }
}
