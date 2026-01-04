package com.example.ragjobbrowser;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/jobs")
    Call<List<Job>> getAllJobs();

    @GET("api/jobs/search")
    Call<List<Job>> searchJobs(@Query("q") String query);
}
